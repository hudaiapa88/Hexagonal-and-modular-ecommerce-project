package com.uc.catalog.domain.product.usecase;

import com.uc.catalog.domain.product.model.Product;
import com.uc.catalog.domain.product.port.ProductPort;
import com.uc.common.DomainComponent;
import com.uc.common.page.PageData;
import com.uc.common.usecase.NoUseCaseHandler;
import com.uc.common.usecase.UseCaseHandler;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
@DomainComponent
@RequiredArgsConstructor
public class GetAllProductPageUseCaseHandler implements UseCaseHandler<PageData<Product>,GetAllProductPageUseCase> {
  private final ProductPort productPort;

    @Override
    public PageData<Product> handle(GetAllProductPageUseCase getAllProductPageUseCase) {
        return productPort.getAll(getAllProductPageUseCase.getPageableProperties());
    }
}
