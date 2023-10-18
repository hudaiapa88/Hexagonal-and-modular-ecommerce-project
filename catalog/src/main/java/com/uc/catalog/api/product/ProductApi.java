package com.uc.catalog.api.product;

import com.uc.catalog.domain.product.port.ProductPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ProductApi {
    private final ProductPort productPort;
    private final ProductToProductDtoMapper productToProductDtoMapper;

    public ProductDto findById(Long id) {
        return productToProductDtoMapper.convert(productPort.findById(id));
    }

 /*   public ProductDto save(Product product) {
        return null;
    }*/
}
