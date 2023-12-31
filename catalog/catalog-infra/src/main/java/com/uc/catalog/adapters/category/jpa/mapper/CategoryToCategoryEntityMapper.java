package com.uc.catalog.adapters.category.jpa.mapper;



import com.uc.catalog.adapters.category.jpa.entity.CategoryEntity;
import com.uc.catalog.category.model.Category;
import com.uc.catalog.common.mapper.BaseMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategoryToCategoryEntityMapper extends BaseMapper<Category, CategoryEntity> {
}
