package com.uc.catalog.infra.adapters.product;

import com.uc.catalog.domain.common.exception.EntityNotFoundException;
import com.uc.catalog.domain.common.page.PageData;
import com.uc.catalog.domain.common.page.PageableProperties;
import com.uc.catalog.domain.product.model.Product;
import com.uc.catalog.domain.product.port.ProductCommandPort;
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
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Sort.Order;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductCommandAdapter implements ProductCommandPort {

    private final ProductRepository productRepository;
    private final ProductEntityToProductMapper productEntityToProductMapper;
    private final ProductToProductEntityMapper productToProductEntityMapper;


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











    private ProductEntity findById(Long id) {
        return productRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Ürün bulunamadı"));
    }


}
