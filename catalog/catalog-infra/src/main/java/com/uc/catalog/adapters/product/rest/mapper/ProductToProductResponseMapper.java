package com.uc.catalog.adapters.product.rest.mapper;

import com.uc.catalog.adapters.product.rest.response.ProductResponse;
import com.uc.catalog.product.model.Product;

import com.uc.catalog.common.mapper.BaseMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductToProductResponseMapper extends BaseMapper<Product, ProductResponse> {

}
