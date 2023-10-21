package com.uc.catalog.infra.adapters.product.mapper;

import com.uc.catalog.domain.product.model.Product;
import com.uc.catalog.infra.adapters.product.rest.response.ProductResponse;
import com.uc.common.mapper.BaseMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductToProductResponseMapper extends BaseMapper<Product, ProductResponse> {
}
