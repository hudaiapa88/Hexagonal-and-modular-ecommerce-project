package com.uc.product.domain.model;

import lombok.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Product {
    private Long id;
    private String title;
}
