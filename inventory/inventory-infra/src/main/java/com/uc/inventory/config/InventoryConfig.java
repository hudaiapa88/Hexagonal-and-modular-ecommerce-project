package com.uc.inventory.config;


import com.uc.inventory.common.DomainComponent;
import org.springframework.context.annotation.*;


@Configuration
@PropertySources({
        @PropertySource("classpath:inventory.properties"),
        @PropertySource(value = "classpath:/inventory-${spring.profiles.active}.properties", ignoreResourceNotFound = true)
})
@ComponentScan(
        basePackages =
                "com.uc.inventory",
        includeFilters = {
                @ComponentScan.Filter(type = FilterType.ANNOTATION, value = {DomainComponent.class})
        }
)
public class InventoryConfig {
}
