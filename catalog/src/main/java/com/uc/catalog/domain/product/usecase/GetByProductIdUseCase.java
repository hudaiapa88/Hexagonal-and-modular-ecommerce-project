package com.uc.catalog.domain.product.usecase;

import com.uc.common.usecase.UseCase;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GetByProductIdUseCase implements UseCase {
    private Long id;
}
