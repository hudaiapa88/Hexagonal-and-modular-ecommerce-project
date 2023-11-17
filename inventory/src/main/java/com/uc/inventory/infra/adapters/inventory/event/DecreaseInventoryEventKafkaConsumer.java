package com.uc.inventory.infra.adapters.inventory.event;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.uc.common.event.EventPublisher;
import com.uc.common.usecase.BeanAwareUseCasePublisher;
import com.uc.inventory.domain.inventory.event.DecreaseInventoryEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class DecreaseInventoryEventKafkaConsumer extends BeanAwareUseCasePublisher {

    private final ObjectMapper objectMapper;

    @KafkaListener(topics = {"${kafka.inventory.consumer.decreaseInventory.topic}"}, groupId = "${kafka.inventory.consumer.decreaseInventory.group-id}", containerFactory = "decreaseInventoryConsumerContainerFactory")
    public void consume(@Payload DecreaseInventoryEvent event) {
        publish(event.toModel());
    }
}
