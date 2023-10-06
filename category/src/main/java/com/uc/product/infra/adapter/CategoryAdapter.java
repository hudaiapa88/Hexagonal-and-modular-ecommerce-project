package com.uc.product.infra.adapter;

import com.uc.product.domain.model.Category;
import com.uc.product.domain.port.CategoryPort;
import com.uc.product.domain.usecase.CreateCategoryUseCase;
import com.uc.product.infra.jpa.entity.CategoryEntity;
import com.uc.product.infra.jpa.repository.CategoryRepository;
import com.uc.product.infra.mapper.CategoryEntityToCategoryMapper;
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
