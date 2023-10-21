package com.uc.catalog.domain.category.usecase;

import com.uc.common.usecase.UseCase;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class GetByCategoryIdUseCase implements UseCase {
    private Long id;
}
