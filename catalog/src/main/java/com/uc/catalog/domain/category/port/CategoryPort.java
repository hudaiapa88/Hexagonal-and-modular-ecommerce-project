package com.uc.catalog.domain.category.port;

import com.uc.catalog.domain.category.usecase.CreateCategoryUseCase;
import com.uc.catalog.domain.category.model.Category;
import com.uc.catalog.domain.category.usecase.DeleteCategoryUseCase;
import com.uc.catalog.domain.category.usecase.UpdateCategoryUseCase;

public interface CategoryPort{

    Category create(CreateCategoryUseCase createCategoryUseCase);

    Category update(UpdateCategoryUseCase value);

    Category findById(Long id);

    void delete(DeleteCategoryUseCase value);
}
