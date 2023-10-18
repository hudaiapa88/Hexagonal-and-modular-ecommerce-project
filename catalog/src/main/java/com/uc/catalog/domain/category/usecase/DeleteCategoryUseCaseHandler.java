package com.uc.catalog.domain.category.usecase;


import com.uc.catalog.domain.category.port.CategoryPort;
import com.uc.common.DomainComponent;
import com.uc.common.usecase.VoidUseCaseHandler;
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
