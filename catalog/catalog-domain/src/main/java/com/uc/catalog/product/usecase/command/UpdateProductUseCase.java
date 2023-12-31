package com.uc.catalog.product.usecase.command;

import com.uc.catalog.common.usecase.UseCase;
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
