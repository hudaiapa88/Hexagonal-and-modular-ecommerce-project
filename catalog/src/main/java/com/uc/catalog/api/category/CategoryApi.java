package com.uc.catalog.api.category;

import com.uc.catalog.domain.category.port.CategoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CategoryApi  {

    private final CategoryPort categoryPort;
    private final CategoryToCategoryDtoMapper categoryToCategoryDtoMapper;

    public CategoryDto findById(Long id) {
        return categoryToCategoryDtoMapper.convert(categoryPort.findById(id));
    }

}
