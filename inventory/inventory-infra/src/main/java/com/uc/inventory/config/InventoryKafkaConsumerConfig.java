package com.uc.inventory.config;



import com.uc.inventory.inventory.event.DecreaseInventoryEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.listener.ContainerProperties;
import org.springframework.kafka.support.serializer.JsonDeserializer;


import java.util.HashMap;
import java.util.Map;

import static java.util.Objects.nonNull;

@Configuration
@RequiredArgsConstructor
@Slf4j
public class InventoryKafkaConsumerConfig {

    private final InventoryKafkaProperties inventoryKafkaProperties;

    @Bean
    @Qualifier("decreaseInventoryConsumer")
    public ConcurrentKafkaListenerContainerFactory<String, DecreaseInventoryEvent> decreaseInventoryConsumerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, DecreaseInventoryEvent> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerFactory("decreaseInventoryConsumer"));
        factory.getContainerProperties().setAckMode(ContainerProperties.AckMode.MANUAL_IMMEDIATE);
        return factory;
    }

    private ConsumerFactory<String, DecreaseInventoryEvent> consumerFactory(String consumerName) {
        Map<String, Object> properties = new HashMap<>(inventoryKafkaProperties.buildCommonProperties());
        if (nonNull(inventoryKafkaProperties.getConsumer())) {
            KafkaProperties.Consumer consumerProperties = inventoryKafkaProperties.getConsumer().get(consumerName);
            if (nonNull(consumerProperties)) {
                properties.putAll(consumerProperties.getProperties());
            }

        }
        log.info("Kafka Consumer '{}' properties: {}", consumerName, properties);
        return new DefaultKafkaConsumerFactory<>(properties, new StringDeserializer(),
                new JsonDeserializer<>(DecreaseInventoryEvent.class));
    }
}
