package com.uc.inventory.adapters.inventory.event;

import com.fasterxml.jackson.databind.ObjectMapper;

import com.uc.inventory.common.usecase.InventoryBeanAwareUseCasePublisher;
import com.uc.inventory.inventory.event.DecreaseInventoryEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class DecreaseInventoryEventKafkaConsumer extends InventoryBeanAwareUseCasePublisher {

    private final ObjectMapper objectMapper;

    @KafkaListener(topics = {"${kafka.inventory.consumer.decreaseInventory.topic}"}, groupId = "${kafka.inventory.consumer.decreaseInventory.group-id}", containerFactory = "decreaseInventoryConsumerContainerFactory")
    public void consume(@Payload DecreaseInventoryEvent event) {
        publish(event.toModel());
    }
}
