package com.uc.catalog.category.usecase;

import com.uc.catalog.common.usecase.UseCase;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateCategoryUseCase implements UseCase {
    private Long id;
    private String title;
}
