package com.uc.product.infra.rest.request;

import com.uc.product.domain.usecase.CreateProductUseCase;
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
