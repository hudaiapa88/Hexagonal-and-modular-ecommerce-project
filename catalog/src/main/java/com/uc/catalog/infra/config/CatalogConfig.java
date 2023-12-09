package com.uc.catalog.infra.config;

import com.uc.common.page.PageableProperties;
import org.springdoc.core.utils.SpringDocUtils;
import org.springframework.context.annotation.*;

@Configuration
@PropertySources({
        @PropertySource("classpath:catalog.properties"),
        @PropertySource(value = "classpath:/catalog-${spring.profiles.active}.properties", ignoreResourceNotFound = true)
})
public class CatalogConfig {

}
