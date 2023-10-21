package com.uc.catalog.domain.category.usecase;

import com.uc.common.usecase.UseCase;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.Value;

@Getter
@Setter
@AllArgsConstructor
public class CreateCategoryUseCase implements UseCase {
    private String title;
}
