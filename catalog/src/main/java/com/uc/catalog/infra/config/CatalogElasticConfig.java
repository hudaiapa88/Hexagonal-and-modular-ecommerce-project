package com.uc.catalog.infra.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.elc.ElasticsearchConfiguration;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

@Configuration
@EnableElasticsearchRepositories(basePackages = {"com.uc.catalog.infra.adapters.product.elastic"})
@ComponentScan(basePackages = { "com.uc.catalog.infra" })
@EnableConfigurationProperties
@ConfigurationProperties(prefix = "catalog.elasticsearch")
@Getter
@Setter
public class CatalogElasticConfig extends ElasticsearchConfiguration {
    private String url;
    @Override
    public ClientConfiguration clientConfiguration() {
        return ClientConfiguration.builder()
                .connectedTo(url)
                .build();
    }
}
