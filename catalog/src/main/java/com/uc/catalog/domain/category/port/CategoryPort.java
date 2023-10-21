package com.uc.catalog.domain.category.port;

import com.uc.catalog.domain.category.usecase.CreateCategoryUseCase;
import com.uc.catalog.domain.category.model.Category;
import com.uc.catalog.domain.category.usecase.DeleteCategoryUseCase;
import com.uc.catalog.domain.category.usecase.UpdateCategoryUseCase;

import java.util.List;

public interface CategoryPort{

    Category save(Category category);

    Category findById(Long id);

    void delete(DeleteCategoryUseCase value);

    List<Category> getAll();
}
