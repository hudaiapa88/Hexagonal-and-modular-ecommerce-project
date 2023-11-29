package com.uc.catalog.infra.adapters.product.elastic.repository;

import com.uc.catalog.infra.adapters.product.elastic.model.ProductElastic;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;


import java.util.List;

public interface ProductElasticRepository extends ElasticsearchRepository<ProductElastic,Long> {

   /* @Query("{ \"query\" : {\n" +
            "\"bool\" : {\n" +
            "\"must\" : [\n" +
            "{ \"query_string\" : { \"query\" : \"?\", \"fields\" : [ \"title\" ] } }\n" +
            "]\n" +
            "}\n" +
            "}}")*/
    Page<ProductElastic> findByTitle(String title,Pageable pageable);
    List<ProductElastic> findByTitle(String title);
    @Query("{\"bool\": {\"must\": {\"match_phrase_prefix\": {\"title\": \"?0\"}}}}")
    List<ProductElastic> customAutocompleteSearch(String input);

    Page<ProductElastic> findByCategoryTitle(String categoryTitle, Pageable pageable);
}
