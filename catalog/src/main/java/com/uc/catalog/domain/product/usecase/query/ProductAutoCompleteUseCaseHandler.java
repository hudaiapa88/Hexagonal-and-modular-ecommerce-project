package com.uc.catalog.domain.product.usecase.query;

import com.uc.catalog.domain.product.port.ProductCommandPort;
import  com.uc.catalog.domain.common.DomainComponent;
import  com.uc.catalog.domain.common.usecase.UseCaseHandler;;
import com.uc.catalog.domain.product.port.ProductQueryPort;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
@DomainComponent
@RequiredArgsConstructor
public class ProductAutoCompleteUseCaseHandler implements UseCaseHandler<List<String>, ProductAutocompleteUseCase> {
   private final ProductQueryPort productQueryPort;

    @Override
    public List<String> handle(ProductAutocompleteUseCase value) {
        return productQueryPort.getAutoComplete(value.getInput());
    }
}
