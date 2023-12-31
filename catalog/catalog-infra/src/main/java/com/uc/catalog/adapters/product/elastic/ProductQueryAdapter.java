package com.uc.catalog.adapters.product.elastic;

import com.uc.catalog.common.exception.EntityNotFoundException;
import com.uc.catalog.common.page.PageData;
import com.uc.catalog.common.page.PageableProperties;
import com.uc.catalog.elastic.ESUtil;
import com.uc.catalog.product.model.Product;
import com.uc.catalog.product.port.ProductQueryPort;
import com.uc.catalog.adapters.product.elastic.model.ProductElastic;
import com.uc.catalog.adapters.product.elastic.repository.ProductElasticRepository;
import com.uc.catalog.adapters.product.elastic.mapper.ProductElasticToProductMapper;
import com.uc.catalog.adapters.product.elastic.mapper.ProductToProductElasticMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.SearchHitSupport;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.core.SearchPage;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductQueryAdapter implements ProductQueryPort {

    private final ProductToProductElasticMapper productToProductElasticMapper;
    private final ElasticsearchOperations elasticsearchOperations;
    private final ProductElasticToProductMapper productElasticToProductMapper;
    private final ProductElasticRepository productElasticRepository;
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
    public Product getById(Long id) {
        return productElasticToProductMapper.convert(productElasticRepository.findById(id).orElseThrow(()->new EntityNotFoundException("Product bulunamadı.")));
    }

    @Override
    public List<Product> getByIds(List<Long> ids) {
        return productElasticToProductMapper.convertList(productElasticRepository.findByIdIn(ids));
    }

    private Pageable convertPageableRequest(PageableProperties pageableProperties) {
        PageRequest pageRequest = null;
        if (Optional.ofNullable(pageableProperties.getSort()).isPresent()) {
            List<Sort.Order> orders = pageableProperties.getSort().getOrders().stream().map((order) -> {
                return new Sort.Order(Sort.Direction.fromString(order.getDirection()), order.getProperty());
            }).collect(Collectors.toList());
            pageRequest = PageRequest.of(pageableProperties.getPage(), pageableProperties.getSize(), Sort.by(orders));
        } else {
            pageRequest = PageRequest.of(pageableProperties.getPage(), pageableProperties.getSize());
        }


        return pageRequest;
    }
}
