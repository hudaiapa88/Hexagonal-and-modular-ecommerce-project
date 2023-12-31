package com.uc.catalog.adapters.product.jpa.mapper;

import com.uc.catalog.product.model.Product;
import com.uc.catalog.adapters.product.jpa.entity.ProductEntity;
import com.uc.catalog.common.mapper.BaseMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductToProductEntityMapper extends BaseMapper<Product, ProductEntity> {
}
