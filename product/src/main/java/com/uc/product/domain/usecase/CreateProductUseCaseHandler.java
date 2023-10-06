package com.uc.product.domain.usecase;

import com.uc.product.domain.model.Product;
import com.uc.product.domain.port.ProductPort;
import com.uc.common.DomainComponent;
import com.uc.common.usecase.UseCaseHandler;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@DomainComponent
@RequiredArgsConstructor
public class CreateProductUseCaseHandler implements UseCaseHandler<Product, CreateProductUseCase> {

    private final ProductPort categoryPort;
    @Override
    public Product handle(CreateProductUseCase createProductUseCase) {
        return categoryPort.create(createProductUseCase);
    }
}
