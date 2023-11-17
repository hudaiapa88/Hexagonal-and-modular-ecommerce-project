package com.uc.catalog.domain.product.usecase;

import com.uc.common.usecase.UseCase;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@AllArgsConstructor
public class GetProductByProductIdUseCase implements UseCase {
    private Long id;
}
