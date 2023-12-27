package com.uc.catalog.infra.adapters.product;

import com.uc.catalog.domain.common.exception.EntityNotFoundException;
import com.uc.catalog.domain.common.page.PageData;
import com.uc.catalog.domain.common.page.PageableProperties;
import com.uc.catalog.domain.product.model.Product;
import com.uc.catalog.domain.product.port.ProductPort;
import com.uc.catalog.infra.adapters.product.elastic.model.ProductElastic;
import com.uc.catalog.infra.adapters.product.elastic.repository.ProductElasticRepository;
import com.uc.catalog.infra.adapters.product.jpa.entity.ProductEntity;
import com.uc.catalog.infra.adapters.product.jpa.repository.ProductRepository;
import com.uc.catalog.infra.adapters.product.mapper.ProductElasticToProductMapper;
import com.uc.catalog.infra.adapters.product.mapper.ProductEntityToProductMapper;
import com.uc.catalog.infra.adapters.product.mapper.ProductToProductElasticMapper;
import com.uc.catalog.infra.adapters.product.mapper.ProductToProductEntityMapper;
import com.uc.catalog.infra.util.elastic.ESUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.elasticsearch.core.*;
import org.springframework.data.elasticsearch.core.query.Query;
import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Sort.Order;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
public class ProductAdapter implements ProductPort {

    private final ProductRepository productRepository;
    private final ProductEntityToProductMapper productEntityToProductMapper;
    private final ProductToProductEntityMapper productToProductEntityMapper;
    private final ProductToProductElasticMapper productToProductElasticMapper;
    private final ElasticsearchOperations elasticsearchOperations;
    private final ProductElasticToProductMapper productElasticToProductMapper;
    private final ProductElasticRepository productElasticRepository;

    @Qualifier("productExchange")
    private final DirectExchange exchange;

    @Value("${catalog.rabbitmq.save-product-routing-key}")
    String saveProductRoutingKey;
    @Value("${catalog.rabbitmq.update-product-routing-key}")
    String updateProductRoutingKey;
    @Value("${catalog.rabbitmq.delete-product-routing-key}")
    String deleteProductRoutingKey;
    private final AmqpTemplate rabbitTemplate;

    @Override
    public Product getById(Long id) {
        return productEntityToProductMapper.convert(findById(id));
    }

    @Override
    public List<Product> getByIds(List<Long> ids) {
        return productEntityToProductMapper.convertList(productRepository.findAllById(ids));
    }

    @Override
    public Product save(Product product) {
        ProductEntity productEntity = productRepository.save(productToProductEntityMapper.convert(product));
        product = productEntityToProductMapper.convert(productEntity);
        rabbitTemplate.convertAndSend(exchange.getName(), saveProductRoutingKey, product);
        return product;
    }

    @Override
    public void delete(Long id) {
        productRepository.deleteById(id);
        rabbitTemplate.convertAndSend(exchange.getName(), deleteProductRoutingKey, id);
    }

    @Override
    public PageData<Product> getAll(PageableProperties pageableProperties) {
        Pageable pageable = convertPageableRequest(pageableProperties);
        SearchHits<ProductElastic> searchHits = elasticsearchOperations.search(ESUtil.createMatchAllQuery(pageable), ProductElastic.class);
        SearchPage<ProductElastic> productElasticPage = SearchHitSupport.searchPageFor(searchHits, pageable);
        PageData<Product> productPageData = new PageData<Product>(productElasticPage.getTotalElements(), productElasticPage.getTotalPages(), productElasticPage.getNumber(), productElasticPage.getNumberOfElements(),
                productElasticToProductMapper.convertList(productElasticPage.stream()
                        .map(searchHit -> searchHit.getContent()).collect(Collectors.toList()))
        );
        return productPageData;
    }

    @Override
    public PageData<Product> getByTitle(String title, PageableProperties pageableProperties) {
        Page<ProductElastic> productElasticPage = productElasticRepository.findByTitle(title, convertPageableRequest(pageableProperties));
        PageData<Product> productPageData = new PageData<Product>(productElasticPage.getTotalElements(), productElasticPage.getTotalPages(), productElasticPage.getNumber(), productElasticPage.getNumberOfElements(),
                productElasticToProductMapper.convertList(productElasticPage.getContent())
        );
        return productPageData;
    }

    @Override
    public PageData<Product> getByCategoryTitle(String categoryTitle, PageableProperties pageableProperties) {
        Page<ProductElastic> productElasticPage = productElasticRepository.findByCategoryTitle(categoryTitle, convertPageableRequest(pageableProperties));
        PageData<Product> productPageData = new PageData<Product>(productElasticPage.getTotalElements(), productElasticPage.getTotalPages(), productElasticPage.getNumber(), productElasticPage.getNumberOfElements(),
                productElasticToProductMapper.convertList(productElasticPage.getContent())
        );
        return productPageData;
    }

    @Override
    public PageData<Product> getByPriceRange(BigDecimal minPrice, BigDecimal maxPrice, PageableProperties pageableProperties) {
        Pageable pageable = convertPageableRequest(pageableProperties);
        SearchHits<ProductElastic> searchHits = elasticsearchOperations.search(ESUtil.rangeQuery("price",minPrice.toString(),maxPrice.toString(),pageable), ProductElastic.class);
        SearchPage<ProductElastic> productElasticPage = SearchHitSupport.searchPageFor(searchHits, pageable);
        PageData<Product> productPageData = new PageData<Product>(productElasticPage.getTotalElements(), productElasticPage.getTotalPages(), productElasticPage.getNumber(), productElasticPage.getNumberOfElements(),
                productElasticToProductMapper.convertList(productElasticPage.stream()
                        .map(searchHit -> searchHit.getContent()).collect(Collectors.toList()))
        );
        return productPageData;
    }

    @Override
    public List<String> getAutoComplete(String input) {
        return productElasticRepository.customAutocompleteSearch(input,PageRequest.of(0,20)).getContent().stream().map(productElastic -> productElastic.getTitle()).collect(Collectors.toList());
    }

    private ProductEntity findById(Long id) {
        return productRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Ürün bulunamadı"));
    }

    private Pageable convertPageableRequest(PageableProperties pageableProperties) {
        PageRequest pageRequest = null;
        if (Optional.ofNullable(pageableProperties.getSort()).isPresent()) {
            List<Order> orders = pageableProperties.getSort().getOrders().stream().map((order) -> {
                return new Order(Sort.Direction.fromString(order.getDirection()), order.getProperty());
            }).collect(Collectors.toList());
            pageRequest = PageRequest.of(pageableProperties.getPage(), pageableProperties.getSize(), Sort.by(orders));
        } else {
            pageRequest = PageRequest.of(pageableProperties.getPage(), pageableProperties.getSize());
        }


        return pageRequest;
    }
}
