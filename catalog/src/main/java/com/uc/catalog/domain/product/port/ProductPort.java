package com.uc.catalog.domain.product.port;

import com.uc.catalog.domain.product.model.Product;

public interface ProductPort {

    Product findById(Long id);

    Product save(Product product);
}
