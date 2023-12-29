package com.uc.catalog.domain.product.usecase.command;

import  com.uc.catalog.domain.common.usecase.UseCase;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class UpdateProductUseCase implements UseCase {
    private Long id;
    private String title;
    private BigDecimal price;
}
