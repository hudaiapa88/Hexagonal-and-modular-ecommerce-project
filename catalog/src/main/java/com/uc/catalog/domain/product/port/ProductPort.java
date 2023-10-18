package com.uc.catalog.domain.product.port;

import com.uc.catalog.domain.category.model.Category;
import com.uc.catalog.domain.product.model.Product;
import com.uc.catalog.domain.product.usecase.CreateProductUseCase;

public interface ProductPort {

    Product findById(Long id);

    Product save(Product product);
}
