package com.uc.catalog.infra.adapters.product.elastic.mapper;

import com.uc.catalog.domain.product.model.Product;
import com.uc.catalog.infra.adapters.product.elastic.model.ProductElastic;
import com.uc.catalog.infra.common.mapper.BaseMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductToProductElasticMapper extends BaseMapper<Product, ProductElastic> {
}
