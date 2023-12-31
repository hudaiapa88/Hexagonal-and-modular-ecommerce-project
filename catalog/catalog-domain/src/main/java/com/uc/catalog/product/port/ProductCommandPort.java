package com.uc.catalog.product.port;




import com.uc.catalog.product.model.Product;

import java.util.List;

public interface ProductCommandPort {

    Product getById(Long id);
    List<Product> getByIds(List<Long> ids);

    Product save(Product product);
    void delete(Long productId);


}
