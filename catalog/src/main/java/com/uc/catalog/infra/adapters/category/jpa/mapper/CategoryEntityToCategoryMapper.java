package com.uc.catalog.infra.adapters.category.jpa.mapper;

import com.uc.catalog.domain.category.model.Category;
import com.uc.catalog.infra.adapters.category.jpa.entity.CategoryEntity;
import com.uc.catalog.infra.common.mapper.BaseMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategoryEntityToCategoryMapper extends BaseMapper<CategoryEntity, Category> {
}
