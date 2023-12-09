package com.uc.order.infra.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@PropertySources({
        @PropertySource("classpath:order.properties"),
        @PropertySource(value = "classpath:/order-${spring.profiles.active}.properties", ignoreResourceNotFound = true)
})
public class OrderConfig {
}
