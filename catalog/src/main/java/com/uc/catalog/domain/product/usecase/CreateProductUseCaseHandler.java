package com.uc.catalog.domain.product.usecase;

import com.uc.catalog.domain.category.model.Category;
import com.uc.catalog.domain.category.port.CategoryPort;
import com.uc.catalog.domain.product.port.ProductPort;
import com.uc.catalog.domain.product.model.Product;
import com.uc.common.DomainComponent;
import com.uc.common.usecase.UseCaseHandler;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@DomainComponent
@RequiredArgsConstructor
public class CreateProductUseCaseHandler implements UseCaseHandler<Product, CreateProductUseCase> {

    private final ProductPort productPort;
    private final CategoryPort categoryPort;
    @Override
    public Product handle(CreateProductUseCase createProductUseCase) {
        Category category= categoryPort.findById(createProductUseCase.getCategoryId());
        Product product= new Product();
        product.setTitle(createProductUseCase.getTitle());
        product.setCategory(category);
        product.setPrice(createProductUseCase.getPrice());
        return productPort.save(product);
    }
}
