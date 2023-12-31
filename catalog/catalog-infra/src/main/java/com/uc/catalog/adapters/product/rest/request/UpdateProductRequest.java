package com.uc.catalog.adapters.product.rest.request;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class UpdateProductRequest {
    private String title;
    private Long categoryId;
    private BigDecimal price;
}
