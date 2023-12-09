package com.uc.inventory.infra.adapters.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;


@Configuration
@PropertySources({
        @PropertySource("classpath:inventory.properties"),
        @PropertySource(value = "classpath:/inventory-${spring.profiles.active}.properties", ignoreResourceNotFound = true)
})
public class InventoryConfig {
}
