package com.uc.catalog.domain.product.usecase;

import com.uc.catalog.domain.category.model.Category;
import com.uc.catalog.domain.category.port.CategoryPort;
import com.uc.catalog.domain.product.model.Product;
import com.uc.catalog.domain.product.port.ProductPort;
import com.uc.common.DomainComponent;
import com.uc.common.usecase.UseCaseHandler;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@DomainComponent
@RequiredArgsConstructor
public class ChangeCategoryUseCaseHandler implements UseCaseHandler<Product, ChangeCategoryUseCase> {
    private final ProductPort productPort;
    private final CategoryPort categoryPort;
    @Override
    public Product handle(ChangeCategoryUseCase changeCategoryUseCase) {
        Product product=productPort.getById(changeCategoryUseCase.getId());
        Category category=categoryPort.findById(changeCategoryUseCase.getCategoryId());
        product.setCategory(category);
        return productPort.save(product);
    }
}
