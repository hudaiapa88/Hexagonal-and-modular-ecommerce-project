package com.uc.catalog.product.usecase.command;

;
import com.uc.catalog.common.DomainComponent;
import com.uc.catalog.common.usecase.VoidUseCaseHandler;
import com.uc.catalog.product.port.ProductCommandPort;
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
