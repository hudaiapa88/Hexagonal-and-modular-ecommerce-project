package com.uc.product.infra.mapper;

import com.uc.product.domain.model.Product;
import com.uc.product.infra.jpa.entity.ProductEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductEntityToProductMapper extends BaseMapper<ProductEntity, Product>{
}
