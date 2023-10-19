package com.uc.order.infra.config;

import jakarta.persistence.EntityManagerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef = "orderEntityManagerFactory",
        transactionManagerRef = "orderTransactionManager",
        basePackages = { "com.uc.order.infra" })
@EntityScan(basePackages = "com.uc.order.infra")

public class OrderDatasourceConfig {

    @Bean(name="orderProperties")
    @ConfigurationProperties("order.datasource")
    public DataSourceProperties dataSourceProperties() {

        return new DataSourceProperties();
    }

    @Bean(name="orderDatasource")
    @ConfigurationProperties(prefix = "order.datasource")
    public DataSource datasource(@Qualifier("orderProperties") DataSourceProperties properties){

        return properties.initializeDataSourceBuilder().build();
    }

    @Bean(name="orderEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean
            (EntityManagerFactoryBuilder builder,
             @Qualifier("orderDatasource") DataSource dataSource){

        return builder.dataSource(dataSource)
                .packages("com.uc.order.infra")
                .persistenceUnit("order").build();
    }

    @Bean(name = "orderTransactionManager")
    @ConfigurationProperties("spring.jpa")
    public PlatformTransactionManager transactionManager(
            @Qualifier("orderEntityManagerFactory") EntityManagerFactory entityManagerFactory) {

        return new JpaTransactionManager(entityManagerFactory);
    }
}
