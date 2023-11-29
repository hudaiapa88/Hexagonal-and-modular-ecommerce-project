package com.uc.catalog.infra.adapters.category.elastic.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Getter
@Setter
public class CategoryElastic {
    private Long id;
    @Field(name = "title",type = FieldType.Text,fielddata = true, analyzer = "custom_analyzer")
    private String title;
}
