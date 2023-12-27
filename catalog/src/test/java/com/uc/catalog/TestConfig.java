package com.uc.catalog;


import  com.uc.catalog.domain.common.DomainComponent;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
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
