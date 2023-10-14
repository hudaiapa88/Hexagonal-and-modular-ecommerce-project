package com.uc.catalog.infra.adapters.product.rest.request;

import com.uc.catalog.domain.product.usecase.CreateProductUseCase;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateProductRequest {
    private String title;
    public CreateProductUseCase toModel() {
        return new CreateProductUseCase(title);
    }
}
