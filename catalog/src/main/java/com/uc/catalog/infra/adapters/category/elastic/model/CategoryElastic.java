package com.uc.catalog.infra.adapters.category.elastic.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.elasticsearch.annotations.Field;

@Getter
@Setter
public class CategoryElastic {
    private Long id;
    @Field(name = "title")
    private String title;
}
