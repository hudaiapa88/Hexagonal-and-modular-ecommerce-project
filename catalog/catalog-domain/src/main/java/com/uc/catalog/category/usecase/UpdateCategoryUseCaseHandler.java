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
public class UpdateCategoryUseCaseHandler implements UseCaseHandler<Category, UpdateCategoryUseCase> {

    private final CategoryPort categoryPort;
    @Override
    public Category handle(UpdateCategoryUseCase value) {
        Category category=categoryPort.findById(value.getId());
        category.setTitle(value.getTitle());
        return categoryPort.save(category);
    }
}
