package com.uc.catalog.domain.product.model;

import com.uc.catalog.domain.category.model.Category;
import lombok.*;

import java.math.BigDecimal;


@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Product {
    private Long id;
    private String title;
    private Category category;
    private BigDecimal price;
}
