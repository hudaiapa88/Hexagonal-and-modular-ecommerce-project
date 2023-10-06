package com.uc.product.domain.usecase;

import com.uc.product.domain.model.Category;
import com.uc.product.domain.port.CategoryPort;
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
       //Enterprise business rules
        return categoryPort.create(createCategoryUseCase);
    }
}
