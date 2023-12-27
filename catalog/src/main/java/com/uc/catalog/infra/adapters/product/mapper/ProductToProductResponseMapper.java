package com.uc.catalog.infra.adapters.product.mapper;

import com.uc.catalog.domain.product.model.Product;
import com.uc.catalog.infra.adapters.product.rest.response.ProductResponse;
import com.uc.catalog.infra.common.mapper.BaseMapper;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductToProductResponseMapper extends BaseMapper<Product, ProductResponse> {

}
