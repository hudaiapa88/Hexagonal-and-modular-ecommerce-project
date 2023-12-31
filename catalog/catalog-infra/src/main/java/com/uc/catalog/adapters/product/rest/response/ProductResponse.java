package com.uc.catalog.adapters.product.rest.response;

import com.uc.adapters.category.rest.response.CategoryResponse;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class ProductResponse {
    private Long id;
    private String title;
    private CategoryResponse category;
    private BigDecimal price;
}
