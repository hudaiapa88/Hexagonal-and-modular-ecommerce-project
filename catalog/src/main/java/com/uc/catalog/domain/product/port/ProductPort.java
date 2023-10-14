package com.uc.catalog.domain.product.port;

import com.uc.catalog.domain.product.model.Product;
import com.uc.catalog.domain.product.usecase.CreateProductUseCase;

public interface ProductPort {

    Product create(CreateProductUseCase createProductUseCase);

}
