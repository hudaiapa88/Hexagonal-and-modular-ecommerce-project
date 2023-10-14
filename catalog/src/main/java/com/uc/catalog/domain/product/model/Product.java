package com.uc.catalog.domain.product.model;

import lombok.*;

import java.math.BigDecimal;


@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Product {
    private Long id;
    private String title;
    private Long categoryId;
    private BigDecimal price;
    private Integer quantity;
}
