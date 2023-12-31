package com.uc.inventory.config;

import jakarta.persistence.EntityManagerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef = "inventoryEntityManagerFactory",
        transactionManagerRef = "inventoryTransactionManager",
        basePackages = { "com.uc.inventory.adapters.inventory" })
@EntityScan(basePackages = "com.uc.inventory.adapters.inventory")
public class InventoryDatasourceConfig {


    @Bean(name="inventoryProperties")
    @ConfigurationProperties("inventory.datasource")
    public DataSourceProperties dataSourceProperties() {

        return new DataSourceProperties();
    }

    @Bean(name="inventoryDatasource")
    @ConfigurationProperties(prefix = "inventory.datasource")
    public DataSource datasource(@Qualifier("inventoryProperties") DataSourceProperties properties){

        return properties.initializeDataSourceBuilder().build();
    }

    @Bean(name="inventoryEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean
            (EntityManagerFactoryBuilder builder,
             @Qualifier("inventoryDatasource") DataSource dataSource){

        return builder.dataSource(dataSource)
                .packages("com.uc.inventory.adapters.inventory")
                .persistenceUnit("inventory").build();
    }

    @Bean(name = "inventoryTransactionManager")
    @ConfigurationProperties("spring.jpa")
    public PlatformTransactionManager transactionManager(
            @Qualifier("inventoryEntityManagerFactory") EntityManagerFactory entityManagerFactory) {

        return new JpaTransactionManager(entityManagerFactory);
    }
}
