package com.uc.category.infra.mapper;

import com.uc.category.domain.model.Category;
import com.uc.category.infra.rest.response.CategoryResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategoryToCategoryResponseMapper extends BaseMapper<Category, CategoryResponse>{
}
