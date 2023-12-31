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
public class CreateProductUseCaseHandler implements UseCaseHandler<Product, CreateProductUseCase> {

    private final ProductCommandPort productCommandPort;
    private final CategoryPort categoryPort;
    @Override
    public Product handle(CreateProductUseCase createProductUseCase) {
        Category category= categoryPort.findById(createProductUseCase.getCategoryId());
        Product product= new Product();
        product.setTitle(createProductUseCase.getTitle());
        product.setCategory(category);
        product.setPrice(createProductUseCase.getPrice());
        return productCommandPort.save(product);
    }
}
