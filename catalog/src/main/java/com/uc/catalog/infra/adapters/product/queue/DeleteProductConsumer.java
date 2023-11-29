package com.uc.catalog.infra.adapters.product.queue;

import com.uc.catalog.domain.product.model.Product;
import com.uc.catalog.infra.adapters.product.elastic.model.ProductElastic;
import com.uc.catalog.infra.adapters.product.elastic.repository.ProductElasticRepository;
import com.uc.catalog.infra.adapters.product.mapper.ProductToProductElasticMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeleteProductConsumer {
    private final ProductElasticRepository productElasticRepository;
    @RabbitListener(queues = "${catalog.rabbitmq.delete-product-queue}")
    void consume(Long productId){
        productElasticRepository.deleteById(productId);
    }
}
