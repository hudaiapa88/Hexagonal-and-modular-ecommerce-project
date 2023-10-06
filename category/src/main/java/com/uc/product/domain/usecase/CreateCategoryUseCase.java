package com.uc.product.domain.usecase;

import com.uc.common.usecase.UseCase;
import lombok.Value;

@Value
public class CreateCategoryUseCase implements UseCase {
    private String title;
}
