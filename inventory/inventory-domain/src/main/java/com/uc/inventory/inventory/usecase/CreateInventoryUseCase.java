package com.uc.inventory.inventory.usecase;

import com.uc.inventory.common.usecase.UseCase;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateInventoryUseCase implements UseCase {
    private Long productId;
    private Long amount;
}
