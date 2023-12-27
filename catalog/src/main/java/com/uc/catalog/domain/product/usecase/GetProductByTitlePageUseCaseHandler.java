package com.uc.catalog.domain.product.usecase;

import com.uc.catalog.domain.common.page.PageData;
import com.uc.catalog.domain.common.usecase.UseCaseHandler;
import com.uc.catalog.domain.product.model.Product;
import com.uc.catalog.domain.product.port.ProductPort;
import  com.uc.catalog.domain.common.DomainComponent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@DomainComponent
@RequiredArgsConstructor
public class GetProductByTitlePageUseCaseHandler implements UseCaseHandler<PageData<Product>, GetProductByTitlePageUseCase> {

    private final ProductPort productPort;

    @Override
    public PageData<Product> handle(GetProductByTitlePageUseCase value) {
        return productPort.getByTitle(value.getTitle(), value.getPageableProperties());
    }
}
