package com.uc.catalog.domain.product.usecase.command;

import com.uc.catalog.domain.common.usecase.VoidUseCaseHandler;
import com.uc.catalog.domain.product.port.ProductCommandPort;
import  com.uc.catalog.domain.common.DomainComponent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@DomainComponent
@RequiredArgsConstructor
public class DeleteProductUseCaseHandler implements VoidUseCaseHandler<DeleteProductUseCase> {

    private final ProductCommandPort productCommandPort;
    @Override
    public void handle(DeleteProductUseCase value) {
        productCommandPort.delete(value.getId());
    }
}
