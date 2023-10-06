package com.uc.product.infra.mapper;

import com.uc.product.domain.model.Category;
import com.uc.product.infra.rest.response.CategoryResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategoryToCategoryResponseMapper extends BaseMapper<Category, CategoryResponse>{
}
