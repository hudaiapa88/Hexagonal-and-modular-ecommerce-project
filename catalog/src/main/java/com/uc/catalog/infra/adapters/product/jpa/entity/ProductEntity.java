package com.uc.catalog.infra.adapters.product.jpa.entity;

import com.uc.catalog.domain.category.model.Category;
import com.uc.catalog.infra.adapters.category.jpa.entity.CategoryEntity;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Table(name = "product")
public class ProductEntity {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "generator_sequence"
    )
    @SequenceGenerator(
            name = "generator_sequence",
            allocationSize = 1
    )
    private Long id;
    private String title;
    @ManyToOne
    private CategoryEntity category;
    private BigDecimal price;
}
