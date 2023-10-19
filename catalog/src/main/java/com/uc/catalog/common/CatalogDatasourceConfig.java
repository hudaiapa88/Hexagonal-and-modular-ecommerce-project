package com.uc.catalog.common;

import jakarta.persistence.EntityManagerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
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
        entityManagerFactoryRef = "catalogEntityManagerFactory",
        transactionManagerRef = "catalogTransactionManager",
        basePackages = { "com.uc.catalog.infra" })
@EntityScan(basePackages = "com.uc.catalog.infra")
public class CatalogDatasourceConfig {

    @Primary
    @Bean(name="catalogProperties")
    @ConfigurationProperties("catalog.datasource")
    public DataSourceProperties dataSourceProperties() {

        return new DataSourceProperties();
    }
    @Primary
    @Bean(name="catalogDatasource")
    @ConfigurationProperties(prefix = "catalog.datasource")
    public DataSource datasource(@Qualifier("catalogProperties") DataSourceProperties properties){

        return properties.initializeDataSourceBuilder().build();
    }
    @Primary
    @Bean(name="catalogEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean
            (EntityManagerFactoryBuilder builder,
             @Qualifier("catalogDatasource") DataSource dataSource){

        return builder.dataSource(dataSource)
                .packages("com.uc.catalog.infra")
                .persistenceUnit("catalog").build();
    }
    @Primary
    @Bean(name = "catalogTransactionManager")
    @ConfigurationProperties("spring.jpa")
    public PlatformTransactionManager transactionManager(
            @Qualifier("catalogEntityManagerFactory") EntityManagerFactory entityManagerFactory) {

        return new JpaTransactionManager(entityManagerFactory);
    }
}
