package com.uc.catalog.adapters.product.elastic.mapper;

import com.uc.catalog.adapters.product.elastic.model.ProductElastic;
import com.uc.catalog.common.mapper.BaseMapper;
import com.uc.catalog.product.model.Product;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductElasticToProductMapper extends BaseMapper<ProductElastic, Product> {


}
