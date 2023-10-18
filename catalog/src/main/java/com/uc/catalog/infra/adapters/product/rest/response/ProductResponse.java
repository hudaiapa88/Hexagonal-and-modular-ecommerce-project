package com.uc.catalog.infra.adapters.product.rest.response;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class ProductResponse {
    private Long id;
    private String title;
    private Long categoryId;
    private BigDecimal price;
}
