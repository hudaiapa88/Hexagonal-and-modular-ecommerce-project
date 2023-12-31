package com.uc.catalog.product.usecase.command;


import com.uc.catalog.common.usecase.UseCase;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class CreateProductUseCase implements UseCase {
    private String title;
    private Long categoryId;
    private BigDecimal price;
}
