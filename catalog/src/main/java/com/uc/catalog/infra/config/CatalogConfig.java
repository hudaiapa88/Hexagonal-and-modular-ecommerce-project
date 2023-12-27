package com.uc.catalog.infra.config;


import com.uc.catalog.domain.common.DomainComponent;
import org.springframework.context.annotation.*;

@Configuration
@PropertySources({
        @PropertySource("classpath:catalog.properties"),
        @PropertySource(value = "classpath:/catalog-${spring.profiles.active}.properties", ignoreResourceNotFound = true)
})
@ComponentScan(
        basePackages =
                "com.uc",
        includeFilters = {
                @ComponentScan.Filter(type = FilterType.ANNOTATION, value = {DomainComponent.class})
        }
)
public class CatalogConfig {

}
