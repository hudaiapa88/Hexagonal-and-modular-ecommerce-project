package com.uc.category.infra.rest.response;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class CategoryResponse {
    private Long id;
    private String title;
}
