package com.uc.inventory.inventory.usecase;

import com.uc.inventory.common.usecase.UseCase;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class GetInventoryByProductIdUseCase implements UseCase {
    private Long productId;
}
