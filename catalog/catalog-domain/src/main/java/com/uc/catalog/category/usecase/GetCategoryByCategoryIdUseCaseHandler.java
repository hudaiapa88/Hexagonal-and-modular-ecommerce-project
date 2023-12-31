package com.uc.catalog.category.usecase;


import com.uc.catalog.common.DomainComponent;
import com.uc.catalog.common.usecase.UseCaseHandler;
import com.uc.catalog.category.model.Category;
import com.uc.catalog.category.port.CategoryPort;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@DomainComponent
@RequiredArgsConstructor
public class GetCategoryByCategoryIdUseCaseHandler implements UseCaseHandler<Category, GetCategoryByCategoryIdUseCase> {
    private final CategoryPort categoryPort;

    @Override
    public Category handle(GetCategoryByCategoryIdUseCase value) {
        return categoryPort.findById(value.getId());
    }
}
