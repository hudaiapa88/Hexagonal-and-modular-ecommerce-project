package com.uc.catalog.infra.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:catalog.properties")
public class CatalogConfig {
}
