package com.uc.catalog.config;


import com.uc.catalog.common.DomainComponent;
import org.springframework.context.annotation.*;

@Configuration
@PropertySources({
        @PropertySource("classpath:catalog.properties"),
        @PropertySource(value = "classpath:/catalog-${spring.profiles.active}.properties", ignoreResourceNotFound = true)
})
@ComponentScan(
        basePackages =
                "com.uc.catalog",
        includeFilters = {
                @ComponentScan.Filter(type = FilterType.ANNOTATION, value = {DomainComponent.class})
        }
)
public class CatalogConfig {

}
