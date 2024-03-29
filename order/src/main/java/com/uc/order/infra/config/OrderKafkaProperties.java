package com.uc.order.infra.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.boot.autoconfigure.kafka.SslBundleSslEngineFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.ssl.DefaultSslBundleRegistry;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.support.serializer.JsonSerializer;
import org.springframework.util.CollectionUtils;
import org.apache.kafka.clients.CommonClientConfigs;

import java.util.*;
import java.util.stream.Collectors;

@Configuration
@ConfigurationProperties(prefix = "kafka.order")
@Getter
@Setter
public class OrderKafkaProperties {
    private List<String> bootstrapServers = new ArrayList<>(Collections.singletonList("localhost:9092"));
    private String clientId;
    private Map<String, String> properties = new HashMap<>();
    private Map<String, KafkaProperties.Producer> producer;
    private Map<String, KafkaProperties.Consumer> consumer;
    private KafkaProperties.Ssl ssl = new KafkaProperties.Ssl();
    private KafkaProperties.Security security = new KafkaProperties.Security();

    public Map<String, Object> buildCommonProperties() {
        Map<String, Object> properties = new HashMap<>();
        if (this.bootstrapServers != null) {
            properties.put(CommonClientConfigs.BOOTSTRAP_SERVERS_CONFIG, this.bootstrapServers);
        }
        if (this.clientId != null) {
            properties.put(CommonClientConfigs.CLIENT_ID_CONFIG, this.clientId);
        }

       // properties.putAll(this.ssl.buildProperties());
        properties.putAll(this.security.buildProperties());
        if (Optional.ofNullable(this.producer).isPresent()) {
            for (Map.Entry<String, KafkaProperties.Producer> p : this.producer.entrySet()) {
                properties.putAll(p.getValue().getProperties());
            }
        }
        if (Optional.ofNullable(this.consumer).isPresent()) {
            for (Map.Entry<String, KafkaProperties.Consumer> c : this.consumer.entrySet()) {
                properties.putAll(c.getValue().getProperties());
            }
        }

        if (!CollectionUtils.isEmpty(this.properties)) {
            properties.putAll(this.properties);
        }
        return properties;
    }
}
