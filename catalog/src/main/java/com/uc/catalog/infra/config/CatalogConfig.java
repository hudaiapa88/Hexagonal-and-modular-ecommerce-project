package com.uc.catalog.infra.config;

import com.uc.common.page.PageableProperties;
import org.springdoc.core.utils.SpringDocUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:catalog.properties")
public class CatalogConfig {

}
