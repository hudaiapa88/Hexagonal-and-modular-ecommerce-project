package com.uc.category.infra.adapter;

import com.uc.category.domain.model.Category;
import com.uc.category.domain.port.CategoryPort;
import com.uc.category.domain.usecase.CreateCategoryUseCase;
import com.uc.category.infra.jpa.entity.CategoryEntity;
import com.uc.category.infra.jpa.repository.CategoryRepository;
import com.uc.category.infra.mapper.CategoryEntityToCategoryMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CategoryAdapter implements CategoryPort {

    private final CategoryRepository categoryRepository;
    private final CategoryEntityToCategoryMapper categoryEntityToCategoryMapper;

    @Override
    public Category create(CreateCategoryUseCase createCategoryUseCase) {
        CategoryEntity categoryEntity = new CategoryEntity();
        categoryEntity.setTitle(createCategoryUseCase.getTitle());
        return categoryEntityToCategoryMapper.convert(categoryRepository.save(categoryEntity));
    }
}
