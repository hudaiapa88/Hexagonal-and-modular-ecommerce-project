package com.uc.category.domain.port;

import com.uc.category.domain.model.Category;
import com.uc.category.domain.usecase.CreateCategoryUseCase;

public interface CategoryPort {

    Category create(CreateCategoryUseCase createCategoryUseCase);

}
