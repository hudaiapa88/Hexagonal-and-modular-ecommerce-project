package com.uc.catalog.domain.product.port;

import com.uc.catalog.domain.product.model.Product;
import com.uc.common.page.PageData;
import com.uc.common.page.PageableProperties;

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
