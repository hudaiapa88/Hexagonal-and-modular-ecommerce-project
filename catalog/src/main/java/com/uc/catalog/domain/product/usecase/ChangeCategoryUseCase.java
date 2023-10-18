package com.uc.catalog.domain.product.usecase;

import com.uc.catalog.domain.category.model.Category;
import com.uc.common.usecase.UseCase;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ChangeCategoryUseCase implements UseCase {
    private Long id;
    private Long categoryId;
}
