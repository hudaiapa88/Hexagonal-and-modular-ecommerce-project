package com.uc.inventory.infra.adapters.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:inventory.properties")
public class InventoryConfig {
}
