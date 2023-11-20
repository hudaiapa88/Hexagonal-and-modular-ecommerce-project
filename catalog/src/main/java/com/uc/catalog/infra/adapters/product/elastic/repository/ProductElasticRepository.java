package com.uc.catalog.infra.adapters.product.elastic.repository;

import com.uc.catalog.infra.adapters.product.elastic.model.ProductElastic;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

public interface ProductElasticRepository extends ElasticsearchRepository<ProductElastic,Long> {
}
