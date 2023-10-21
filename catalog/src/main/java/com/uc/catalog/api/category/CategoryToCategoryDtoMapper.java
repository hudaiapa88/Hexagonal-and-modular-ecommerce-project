package com.uc.catalog.api.category;

import com.uc.catalog.domain.category.model.Category;
import com.uc.common.mapper.BaseMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategoryToCategoryDtoMapper extends BaseMapper<Category,CategoryDto> {

}
