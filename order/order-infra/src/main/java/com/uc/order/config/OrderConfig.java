package com.uc.order.config;



import com.uc.order.common.DomainComponent;
import org.springframework.context.annotation.*;

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
