package com.uc.catalog.domain.category.usecase;

import com.uc.catalog.domain.category.model.Category;
import com.uc.catalog.domain.category.port.CategoryPort;
import com.uc.common.DomainComponent;
import com.uc.common.usecase.UseCaseHandler;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@DomainComponent
@RequiredArgsConstructor
public class UpdateCategoryUseCaseHandler implements UseCaseHandler<Category, UpdateCategoryUseCase> {

    private final CategoryPort categoryPort;
    @Override
    public Category handle(UpdateCategoryUseCase value) {
        Category category=categoryPort.findById(value.getId());
        return categoryPort.update(value);
    }
}
