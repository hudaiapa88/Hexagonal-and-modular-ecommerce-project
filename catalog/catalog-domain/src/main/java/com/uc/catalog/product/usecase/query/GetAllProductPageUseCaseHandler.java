package com.uc.catalog.product.usecase.query;

import com.uc.catalog.common.DomainComponent;
import com.uc.catalog.common.usecase.UseCaseHandler;
import com.uc.catalog.product.model.Product;
import com.uc.catalog.product.port.ProductQueryPort;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import com.uc.catalog.common.page.PageData;

@Slf4j
@DomainComponent
@RequiredArgsConstructor
public class GetAllProductPageUseCaseHandler implements UseCaseHandler<PageData<Product>,GetAllProductPageUseCase> {
  private final ProductQueryPort productQueryPort;

    @Override
    public PageData<Product> handle(GetAllProductPageUseCase getAllProductPageUseCase) {
        return productQueryPort.getAll(getAllProductPageUseCase.getPageableProperties());
    }
}
