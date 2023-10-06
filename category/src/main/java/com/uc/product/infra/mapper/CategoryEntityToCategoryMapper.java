package com.uc.product.infra.mapper;

import com.uc.product.domain.model.Category;
import com.uc.product.infra.jpa.entity.CategoryEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategoryEntityToCategoryMapper extends BaseMapper<CategoryEntity, Category>{
}
