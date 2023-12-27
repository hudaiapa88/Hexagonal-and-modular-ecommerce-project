package com.uc.catalog.domain.product.port;

import com.uc.catalog.domain.common.page.PageData;
import com.uc.catalog.domain.common.page.PageableProperties;
import com.uc.catalog.domain.product.model.Product;


import java.math.BigDecimal;
import java.util.List;

public interface ProductPort {

    Product getById(Long id);
    List<Product> getByIds(List<Long> ids);

    Product save(Product product);
    void delete(Long productId);
    PageData<Product> getAll(PageableProperties pageableProperties);
    PageData<Product> getByTitle(String title, PageableProperties pageableProperties);
    PageData<Product> getByCategoryTitle(String categoryTitle,PageableProperties pageableProperties);
    PageData<Product> getByPriceRange(BigDecimal minPrice,BigDecimal maxPrice, PageableProperties pageableProperties);

    List<String> getAutoComplete(String input);
}
