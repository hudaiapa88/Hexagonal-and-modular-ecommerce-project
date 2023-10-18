package com.uc.catalog.domain.product.usecase;

import com.uc.catalog.domain.category.model.Category;
import com.uc.common.usecase.UseCase;
import lombok.Getter;
import lombok.Setter;
import lombok.Value;

import java.math.BigDecimal;

@Getter
@Setter
public class CreateProductUseCase implements UseCase {
    private String title;
    private Long categoryId;
    private BigDecimal price;
}
