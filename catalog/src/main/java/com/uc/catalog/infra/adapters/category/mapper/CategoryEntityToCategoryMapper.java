package com.uc.catalog.infra.adapters.category.mapper;

import com.uc.catalog.domain.category.model.Category;
import com.uc.catalog.infra.adapters.category.jpa.entity.CategoryEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategoryEntityToCategoryMapper extends BaseMapper<CategoryEntity, Category>{
}
