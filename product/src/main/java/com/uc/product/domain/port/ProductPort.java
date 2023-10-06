package com.uc.product.domain.port;

import com.uc.product.domain.model.Product;
import com.uc.product.domain.usecase.CreateProductUseCase;

public interface ProductPort {

    Product create(CreateProductUseCase createProductUseCase);

}
