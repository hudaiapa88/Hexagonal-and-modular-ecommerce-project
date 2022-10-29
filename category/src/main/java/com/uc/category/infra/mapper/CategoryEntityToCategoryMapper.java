package com.uc.category.infra.mapper;

import com.uc.category.domain.model.Category;
import com.uc.category.infra.jpa.entity.CategoryEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategoryEntityToCategoryMapper extends BaseMapper<CategoryEntity, Category>{
}
