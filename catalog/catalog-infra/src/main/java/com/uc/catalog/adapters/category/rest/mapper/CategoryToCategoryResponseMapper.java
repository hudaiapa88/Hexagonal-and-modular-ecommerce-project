package com.uc.catalog.adapters.category.rest.mapper;

import com.uc.catalog.category.model.Category;
import com.uc.adapters.category.rest.response.CategoryResponse;

import com.uc.catalog.common.mapper.BaseMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategoryToCategoryResponseMapper extends BaseMapper<Category, CategoryResponse> {
}
