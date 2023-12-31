package com.uc.catalog.category.port;

import com.uc.catalog.category.usecase.DeleteCategoryUseCase;
import com.uc.catalog.category.model.Category;

import java.util.List;

public interface CategoryPort{

    Category save(Category category);

    Category findById(Long id);

    void delete(DeleteCategoryUseCase value);

    List<Category> getAll();
}
