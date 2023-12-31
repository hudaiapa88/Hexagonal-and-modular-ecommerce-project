package com.uc.adapters.category.rest.request;

import com.uc.catalog.category.usecase.CreateCategoryUseCase;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateCategoryRequest {
    private String title;
    public CreateCategoryUseCase toUseCase() {
        return new CreateCategoryUseCase(title);
    }
}
