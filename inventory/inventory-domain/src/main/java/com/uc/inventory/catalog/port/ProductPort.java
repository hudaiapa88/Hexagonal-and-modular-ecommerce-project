package com.uc.inventory.catalog.port;

import com.uc.inventory.catalog.model.Product;

import java.util.List;

public interface ProductPort {
     Product getByProductId(Long id);
     List<Product> getByProductIds(List<Long> ids);
}
