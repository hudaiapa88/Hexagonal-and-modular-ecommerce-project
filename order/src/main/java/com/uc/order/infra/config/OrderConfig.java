package com.uc.order.infra.config;

import com.uc.order.domain.common.DomainComponent;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.*;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@PropertySources({
        @PropertySource("classpath:order.properties"),
        @PropertySource(value = "classpath:/order-${spring.profiles.active}.properties", ignoreResourceNotFound = true)
})
@ComponentScan(
        basePackages =
                "com.uc",
        	includeFilters = {
                    @ComponentScan.Filter(type = FilterType.ANNOTATION, value = {DomainComponent.class})
            }
)
public class OrderConfig {
}
