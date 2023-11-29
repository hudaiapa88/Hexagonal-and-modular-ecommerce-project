package com.uc.catalog.infra.adapters.product.elastic.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.uc.catalog.infra.adapters.category.elastic.model.CategoryElastic;
import com.uc.catalog.infra.adapters.category.jpa.entity.CategoryEntity;
import jakarta.persistence.*;


import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
import org.springframework.data.elasticsearch.annotations.Setting;
import java.math.BigDecimal;

@Getter
@Setter
@Document(indexName = "products_index")
@Setting(settingPath = "static/catalog-es-setting.json")
//@JsonIgnoreProperties(ignoreUnknown = true)
public class ProductElastic {

    @Id
    private Long id;
    @Field(name = "title", type = FieldType.Text,fielddata = true)
    private String title;
    @Field(name = "category", type = FieldType.Nested,includeInParent = true, analyzer = "custom_analyzer")
    private CategoryElastic category;
    @Field(name = "price", type = FieldType.Double)
    private Double price;
}
