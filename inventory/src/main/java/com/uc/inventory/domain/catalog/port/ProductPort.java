package com.uc.inventory.domain.catalog.port;

import com.uc.inventory.domain.catalog.model.Product;

import java.util.List;

public interface ProductPort {
     Product getByProductId(Long id);
     List<Product> getByProductIds(List<Long> ids);
}
