package com.uc.catalog.domain.product.port;

import com.uc.catalog.domain.common.page.PageData;
import com.uc.catalog.domain.common.page.PageableProperties;
import com.uc.catalog.domain.product.model.Product;


import java.math.BigDecimal;
import java.util.List;

public interface ProductCommandPort {

    Product getById(Long id);
    List<Product> getByIds(List<Long> ids);

    Product save(Product product);
    void delete(Long productId);


}
