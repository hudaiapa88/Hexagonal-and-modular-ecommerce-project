package com.uc.catalog.product.usecase.command;


import com.uc.catalog.category.model.Category;
import com.uc.catalog.category.port.CategoryPort;
import com.uc.catalog.common.DomainComponent;
import com.uc.catalog.common.usecase.UseCaseHandler;
import com.uc.catalog.product.model.Product;
import com.uc.catalog.product.port.ProductCommandPort;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@DomainComponent
@RequiredArgsConstructor
public class ChangeCategoryUseCaseHandler implements UseCaseHandler<Product, ChangeCategoryUseCase> {
    private final ProductCommandPort productCommandPort;
    private final CategoryPort categoryPort;
    @Override
    public Product handle(ChangeCategoryUseCase changeCategoryUseCase) {
        Product product= productCommandPort.getById(changeCategoryUseCase.getId());
        Category category=categoryPort.findById(changeCategoryUseCase.getCategoryId());
        product.setCategory(category);
        return productCommandPort.save(product);
    }
}
