package com.uc.catalog.infra.adapters.product.mapper;

import com.uc.catalog.domain.product.model.Product;
import com.uc.catalog.infra.adapters.product.elastic.model.ProductElastic;
import com.uc.common.mapper.BaseMapper;
import org.mapstruct.Mapper;

@Mapper
public interface ProductElasticToProductMapper extends BaseMapper<ProductElastic, Product> {
}
