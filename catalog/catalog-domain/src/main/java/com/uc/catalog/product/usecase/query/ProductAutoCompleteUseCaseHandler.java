package com.uc.catalog.product.usecase.query;


import com.uc.catalog.common.DomainComponent;
import com.uc.catalog.common.usecase.UseCaseHandler;
import com.uc.catalog.product.port.ProductQueryPort;
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
