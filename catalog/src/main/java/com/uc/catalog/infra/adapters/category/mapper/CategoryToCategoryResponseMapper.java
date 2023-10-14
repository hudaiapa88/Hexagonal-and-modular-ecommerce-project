package com.uc.catalog.infra.adapters.category.mapper;

import com.uc.category.domain.category.model.Category;
import com.uc.category.infra.rest.response.CategoryResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategoryToCategoryResponseMapper extends BaseMapper<Category, CategoryResponse> {
}
