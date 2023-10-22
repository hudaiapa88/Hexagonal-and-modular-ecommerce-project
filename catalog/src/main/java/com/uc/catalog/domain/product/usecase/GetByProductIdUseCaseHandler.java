package com.uc.catalog.domain.product.usecase;

import com.uc.catalog.domain.product.model.Product;
import com.uc.catalog.domain.product.port.ProductPort;
import com.uc.common.DomainComponent;
import com.uc.common.usecase.UseCaseHandler;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@DomainComponent
@RequiredArgsConstructor
public class GetByProductIdUseCaseHandler implements UseCaseHandler<Product,GetByProductIdUseCase> {
    private final ProductPort productPort;

    @Override
    public Product handle(GetByProductIdUseCase value) {
        return productPort.getById(value.getId());
    }
}
