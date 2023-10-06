package com.uc.product.infra.mapper;

import com.uc.product.domain.model.Product;
import com.uc.product.infra.rest.response.ProductResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductToProductResponseMapper extends BaseMapper<Product, ProductResponse>{
}
