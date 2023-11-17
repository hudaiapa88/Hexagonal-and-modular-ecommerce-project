package com.uc.inventory.domain.inventory.usecase;

import com.uc.common.usecase.UseCase;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class GetInventoryByProductIdUseCase implements UseCase {
    private Long productId;
}
