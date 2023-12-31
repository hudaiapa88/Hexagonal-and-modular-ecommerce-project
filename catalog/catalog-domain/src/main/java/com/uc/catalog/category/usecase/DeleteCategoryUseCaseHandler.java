package com.uc.catalog.category.usecase;


import com.uc.catalog.common.DomainComponent;
import com.uc.catalog.common.usecase.VoidUseCaseHandler;
import com.uc.catalog.category.port.CategoryPort;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@DomainComponent
@RequiredArgsConstructor
public class DeleteCategoryUseCaseHandler implements VoidUseCaseHandler<DeleteCategoryUseCase> {

    private final CategoryPort categoryPort;

    @Override
    public void handle(DeleteCategoryUseCase value) {
        categoryPort.delete(value);
    }
}
