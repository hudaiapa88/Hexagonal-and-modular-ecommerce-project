package com.uc.catalog.domain.category.usecase;

import com.uc.catalog.domain.category.model.Category;
import com.uc.catalog.domain.category.port.CategoryPort;
import  com.uc.catalog.domain.common.DomainComponent;
import  com.uc.catalog.domain.common.usecase.UseCaseHandler;;
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
