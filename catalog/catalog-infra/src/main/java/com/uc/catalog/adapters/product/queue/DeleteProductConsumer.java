package com.uc.catalog.adapters.product.queue;

import com.uc.catalog.adapters.product.elastic.repository.ProductElasticRepository;
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
