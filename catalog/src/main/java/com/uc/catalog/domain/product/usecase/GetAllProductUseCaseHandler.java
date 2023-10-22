package com.uc.catalog.domain.product.usecase;

import com.uc.catalog.domain.product.model.Product;
import com.uc.catalog.domain.product.port.ProductPort;
import com.uc.common.DomainComponent;
import com.uc.common.usecase.NoUseCaseHandler;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
@DomainComponent
@RequiredArgsConstructor
public class GetAllProductUseCaseHandler implements NoUseCaseHandler<List<Product>> {
  private final ProductPort productPort;

    @Override
    public List<Product> handle() {
        return productPort.getAll();
    }
}
