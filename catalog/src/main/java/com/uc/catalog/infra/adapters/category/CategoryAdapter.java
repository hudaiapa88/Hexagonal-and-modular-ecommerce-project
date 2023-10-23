package com.uc.catalog.infra.adapters.category;


import com.uc.catalog.infra.adapters.category.jpa.entity.CategoryEntity;
import com.uc.common.rest.exception.EntityNotFoundException;
import com.uc.catalog.domain.category.model.Category;
import com.uc.catalog.domain.category.port.CategoryPort;
import com.uc.catalog.domain.category.usecase.DeleteCategoryUseCase;
import com.uc.catalog.infra.adapters.category.jpa.repository.CategoryRepository;
import com.uc.catalog.infra.adapters.category.mapper.CategoryEntityToCategoryMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryAdapter implements CategoryPort {

    private final CategoryRepository categoryRepository;
    private final CategoryEntityToCategoryMapper categoryEntityToCategoryMapper;

    @Override
    public Category save(Category category) {
        CategoryEntity categoryEntity = new CategoryEntity();
        categoryEntity.setTitle(category.getTitle());
        return categoryEntityToCategoryMapper.convert(categoryRepository.save(categoryEntity));
    }


    @Override
    public Category findById(Long id) {
        return categoryEntityToCategoryMapper.convert(findByCategoryId(id));
    }

    @Override
    public void delete(DeleteCategoryUseCase value) {
        categoryRepository.deleteById(value.getId());
    }

    @Override
    public List<Category> getAll() {
        return categoryEntityToCategoryMapper.convertList(categoryRepository.findAll());
    }

    public CategoryEntity findByCategoryId(Long id) {
        CategoryEntity category=categoryRepository.findById(id).orElseThrow(()->new EntityNotFoundException("Kategori bulunamadı"));
        return category;
    }

}
