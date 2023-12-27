package com.uc.catalog.domain.product.usecase;

import com.uc.catalog.domain.product.model.Product;
import com.uc.catalog.domain.product.port.ProductPort;
import  com.uc.catalog.domain.common.DomainComponent;
import  com.uc.catalog.domain.common.usecase.UseCaseHandler;;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@DomainComponent
@RequiredArgsConstructor
public class GetProductByProductIdUseCaseHandler implements UseCaseHandler<Product, GetProductByProductIdUseCase> {
    private final ProductPort productPort;

    @Override
    public Product handle(GetProductByProductIdUseCase value) {
        return productPort.getById(value.getId());
    }
}
