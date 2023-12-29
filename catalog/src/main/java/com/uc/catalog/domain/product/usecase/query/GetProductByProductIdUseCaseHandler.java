package com.uc.catalog.domain.product.usecase.query;

import com.uc.catalog.domain.product.model.Product;
import com.uc.catalog.domain.product.port.ProductCommandPort;
import  com.uc.catalog.domain.common.DomainComponent;
import  com.uc.catalog.domain.common.usecase.UseCaseHandler;;
import com.uc.catalog.domain.product.port.ProductQueryPort;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@DomainComponent
@RequiredArgsConstructor
public class GetProductByProductIdUseCaseHandler implements UseCaseHandler<Product, GetProductByProductIdUseCase> {
    private final ProductQueryPort productQueryPort;

    @Override
    public Product handle(GetProductByProductIdUseCase value) {
        return productQueryPort.getById(value.getId());
    }
}
