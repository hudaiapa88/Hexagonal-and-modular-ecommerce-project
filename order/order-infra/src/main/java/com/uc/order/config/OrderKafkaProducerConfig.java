package com.uc.order.config;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

import java.util.HashMap;
import java.util.Map;

import static java.util.Objects.nonNull;

@Configuration
@RequiredArgsConstructor
@Slf4j
public class OrderKafkaProducerConfig {
    private final OrderKafkaProperties orderKafkaProperties;
    @Bean
    @Qualifier("decreaseInventoryProducer")
    public KafkaTemplate<String, Object> kafkaTemplate() {
        return new KafkaTemplate<>(producerFactory("decreaseInventoryProducer"));
    }

    private ProducerFactory<String, Object> producerFactory(String producerName) {
        Map<String, Object> properties = new HashMap<>(orderKafkaProperties.buildCommonProperties());
        if (nonNull(orderKafkaProperties.getProducer())) {
            KafkaProperties.Producer producerProperties = orderKafkaProperties.getProducer().get(producerName);
            if (nonNull(producerProperties)) {
                properties.putAll(producerProperties.getProperties());
            }
        }
        log.info("Kafka Producer '{}' properties: {}", producerName, properties);
        return new DefaultKafkaProducerFactory<>(properties);
    }
}
