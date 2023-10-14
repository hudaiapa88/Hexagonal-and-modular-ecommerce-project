package com.uc.catalog.domain.category.usecase;

import com.uc.common.usecase.UseCase;
import lombok.Value;

@Value
public class CreateCategoryUseCase implements UseCase {
    private String title;

}
