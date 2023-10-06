package com.uc.product.infra.rest.request;

import com.uc.product.domain.usecase.CreateCategoryUseCase;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateCategoryRequest {
    private String title;
    public CreateCategoryUseCase toModel() {
        return new CreateCategoryUseCase(title);
    }
}
