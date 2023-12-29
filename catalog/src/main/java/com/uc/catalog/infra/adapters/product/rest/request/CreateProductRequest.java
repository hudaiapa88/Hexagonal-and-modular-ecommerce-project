package com.uc.catalog.infra.adapters.product.rest.request;

import com.uc.catalog.domain.product.usecase.command.CreateProductUseCase;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class CreateProductRequest {
    private String title;
    private Long categoryId;
    private BigDecimal price;
    public CreateProductUseCase toModel() {
        CreateProductUseCase createProductUseCase= new CreateProductUseCase();
        createProductUseCase.setTitle(title);
        createProductUseCase.setCategoryId(categoryId);
        createProductUseCase.setPrice(price);
        return createProductUseCase;
    }
}
