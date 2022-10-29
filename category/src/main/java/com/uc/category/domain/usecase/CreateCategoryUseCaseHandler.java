package com.uc.category.domain.usecase;

import com.uc.category.domain.model.Category;
import com.uc.category.domain.port.CategoryPort;
import com.uc.common.DomainComponent;
import com.uc.common.usecase.UseCaseHandler;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@DomainComponent
@RequiredArgsConstructor
public class CreateCategoryUseCaseHandler implements UseCaseHandler<Category, CreateCategoryUseCase> {

    private final CategoryPort categoryPort;
    @Override
    public Category handle(CreateCategoryUseCase createCategoryUseCase) {
        return categoryPort.create(createCategoryUseCase);
    }
}
