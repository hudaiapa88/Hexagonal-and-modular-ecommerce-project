package com.uc.product.domain.port;

import com.uc.product.domain.model.Category;
import com.uc.product.domain.usecase.CreateCategoryUseCase;

public interface CategoryPort {

    Category create(CreateCategoryUseCase createCategoryUseCase);

}
