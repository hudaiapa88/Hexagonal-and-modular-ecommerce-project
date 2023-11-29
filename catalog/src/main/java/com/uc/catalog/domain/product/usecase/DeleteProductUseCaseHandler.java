package com.uc.catalog.domain.product.usecase;

import com.uc.catalog.domain.product.port.ProductPort;
import com.uc.common.DomainComponent;
import com.uc.common.usecase.VoidUseCaseHandler;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@DomainComponent
@RequiredArgsConstructor
public class DeleteProductUseCaseHandler implements VoidUseCaseHandler<DeleteProductUseCase> {

    private final ProductPort productPort;
    @Override
    public void handle(DeleteProductUseCase value) {
        productPort.delete(value.getId());
    }
}
