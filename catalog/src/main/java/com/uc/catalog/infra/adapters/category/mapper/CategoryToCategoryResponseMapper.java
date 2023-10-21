package com.uc.catalog.infra.adapters.category.mapper;

import com.uc.catalog.domain.category.model.Category;
import com.uc.catalog.infra.adapters.category.rest.response.CategoryResponse;
import com.uc.common.mapper.BaseMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategoryToCategoryResponseMapper extends BaseMapper<Category, CategoryResponse> {
}
