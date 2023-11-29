package com.uc.catalog.domain.product.usecase;

import com.uc.catalog.domain.product.model.Product;
import com.uc.catalog.domain.product.port.ProductPort;
import com.uc.common.DomainComponent;
import com.uc.common.page.PageData;
import com.uc.common.usecase.UseCaseHandler;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@DomainComponent
@RequiredArgsConstructor
public class GetProductByPriceRangePageUseCaseHandler implements UseCaseHandler<PageData<Product>, GetProductByPriceRangePageUseCase> {
    private final ProductPort productPort;


    @Override
    public PageData<Product> handle(GetProductByPriceRangePageUseCase value) {
        return productPort.getByPriceRange(value.getMinPrice(),value.getMaxPrice(), value.getPageableProperties());
    }
}
