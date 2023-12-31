package com.uc.catalog.product.usecase.query;

import com.uc.catalog.common.page.PageData;
import com.uc.catalog.common.DomainComponent;
import com.uc.catalog.common.usecase.UseCaseHandler;
import com.uc.catalog.product.model.Product;
import com.uc.catalog.product.port.ProductQueryPort;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@DomainComponent
@RequiredArgsConstructor
public class GetProductByPriceRangePageUseCaseHandler implements UseCaseHandler<PageData<Product>, GetProductByPriceRangePageUseCase> {
    private final ProductQueryPort productQueryPort;


    @Override
    public PageData<Product> handle(GetProductByPriceRangePageUseCase value) {
        return productQueryPort.getByPriceRange(value.getMinPrice(),value.getMaxPrice(), value.getPageableProperties());
    }
}
