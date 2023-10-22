package com.uc.catalog.domain.product.port;

import com.uc.catalog.domain.product.model.Product;

import java.util.List;

public interface ProductPort {

    Product getById(Long id);
    List<Product> getByIds(List<Long> ids);

    Product save(Product product);

    List<Product> getAll();
}
