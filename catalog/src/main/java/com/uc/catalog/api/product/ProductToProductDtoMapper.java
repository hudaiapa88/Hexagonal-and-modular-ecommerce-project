package com.uc.catalog.api.product;

import com.uc.catalog.domain.product.model.Product;
import com.uc.catalog.infra.adapters.product.mapper.BaseMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductToProductDtoMapper extends BaseMapper<Product,ProductDto> {
}
