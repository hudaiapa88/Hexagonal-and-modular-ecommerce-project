package com.uc.catalog.infra.adapters.category.jpa;


import com.uc.catalog.domain.common.exception.EntityNotFoundException;
import com.uc.catalog.infra.adapters.category.jpa.entity.CategoryEntity;
import com.uc.catalog.infra.adapters.category.jpa.mapper.CategoryToCategoryEntityMapper;
import com.uc.catalog.domain.category.model.Category;
import com.uc.catalog.domain.category.port.CategoryPort;
import com.uc.catalog.domain.category.usecase.DeleteCategoryUseCase;
import com.uc.catalog.infra.adapters.category.jpa.repository.CategoryRepository;
import com.uc.catalog.infra.adapters.category.jpa.mapper.CategoryEntityToCategoryMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryAdapter implements CategoryPort {

    private final CategoryRepository categoryRepository;
    private final CategoryEntityToCategoryMapper categoryEntityToCategoryMapper;
    private final CategoryToCategoryEntityMapper categoryToCategoryEntityMapper;

    @Override
    @Caching( evict = {@CacheEvict(value = "categories", allEntries = true,cacheManager = "categoryCacheManager")})
    public Category save(Category category) {
        CategoryEntity categoryEntity = categoryRepository.save(categoryToCategoryEntityMapper.convert(category));
        return categoryEntityToCategoryMapper.convert(categoryEntity);
    }


    @Override
    public Category findById(Long id) {
        return categoryEntityToCategoryMapper.convert(findByCategoryId(id));
    }

    @Override
    @Caching(   evict = {
                    @CacheEvict(value = "category", key = "#id",cacheManager = "categoryCacheManager"),
                    @CacheEvict(value = "categories", allEntries = true,cacheManager = "categoryCacheManager")
            }
    )
    public void delete(DeleteCategoryUseCase value) {
        categoryRepository.deleteById(value.getId());
    }

    @Override
    @Cacheable(cacheManager = "categoryCacheManager"
            , value = "categories", unless = "#result.size() == 0")
    public List<Category> getAll() {
        return categoryEntityToCategoryMapper.convertList(categoryRepository.findAll());
    }

    public CategoryEntity findByCategoryId(Long id) {
        CategoryEntity category = categoryRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Kategori bulunamadı"));
        return category;
    }

}
