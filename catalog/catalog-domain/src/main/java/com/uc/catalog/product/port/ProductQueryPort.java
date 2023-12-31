package com.uc.catalog.product.port;



import com.uc.catalog.product.model.Product;
import com.uc.catalog.common.page.PageData;
import java.math.BigDecimal;
import java.util.List;
import com.uc.catalog.common.page.PageableProperties;

public interface ProductQueryPort {
   PageData<Product> getByTitle(String title, PageableProperties pageableProperties);
    PageData<Product> getByCategoryTitle(String categoryTitle,PageableProperties pageableProperties);
    PageData<Product> getByPriceRange(BigDecimal minPrice, BigDecimal maxPrice, PageableProperties pageableProperties);
    List<String> getAutoComplete(String input);
    PageData<Product> getAll(PageableProperties pageableProperties);
    Product getById(Long id);
    List<Product> getByIds(List<Long> ids);
}
