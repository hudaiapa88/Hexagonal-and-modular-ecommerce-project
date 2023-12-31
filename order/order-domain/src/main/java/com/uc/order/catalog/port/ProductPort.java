package com.uc.order.catalog.port;


import com.uc.order.catalog.model.Product;

import java.util.List;

public interface ProductPort {
     Product getByProductId(Long id);
     List<Product> getByProductIds(List<Long> ids);
}
