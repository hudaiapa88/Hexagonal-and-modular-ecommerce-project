package com.uc.catalog.domain.product.usecase;

import com.uc.common.usecase.UseCase;
import lombok.Value;

import java.math.BigDecimal;

@Value
public class CreateProductUseCase implements UseCase {
    private String title;
    private Long categoryId;
    private BigDecimal price;
    private Integer quantity;
}
