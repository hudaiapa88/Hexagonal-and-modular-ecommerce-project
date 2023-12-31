package com.uc.catalog.adapters.product.queue;

import com.uc.catalog.product.model.Product;
import com.uc.catalog.adapters.product.elastic.model.ProductElastic;
import com.uc.catalog.adapters.product.elastic.repository.ProductElasticRepository;
import com.uc.catalog.adapters.product.elastic.mapper.ProductToProductElasticMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SaveProductConsumer {
    private final ProductElasticRepository productElasticRepository;
    private final ProductToProductElasticMapper productToProductElasticMapper;

    @RabbitListener(queues = "${catalog.rabbitmq.save-product-queue}")
    void consume(Product product){
        ProductElastic productElastic=productToProductElasticMapper.convert(product);
        productElasticRepository.save(productElastic);
    }

}
