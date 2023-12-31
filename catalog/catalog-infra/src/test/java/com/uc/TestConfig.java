package com.uc;


import com.uc.catalog.common.DomainComponent;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("test")
/*@EnableAutoConfiguration(exclude = {
        DataSourceAutoConfiguration.class,
        DataSourceTransactionManagerAutoConfiguration.class,
        HibernateJpaAutoConfiguration.class,
        RedisAutoConfiguration.class
})*/
@ComponentScan(
        excludeFilters = {
                @ComponentScan.Filter(type = FilterType.REGEX, pattern = ".*Adapter.*"),
                @ComponentScan.Filter(type = FilterType.REGEX, pattern = ".*Config.*"),
                @ComponentScan.Filter(type = FilterType.REGEX, pattern = ".*JpaRepository.*"),
                @ComponentScan.Filter(type = FilterType.REGEX, pattern = ".*Fake.*"),
                @ComponentScan.Filter(type = FilterType.REGEX, pattern = ".*PaymentApiApplication.*")
        } ,
       includeFilters = {
                @ComponentScan.Filter(type = FilterType.ANNOTATION, value = {DomainComponent.class})
        }
)
public class TestConfig {

}
