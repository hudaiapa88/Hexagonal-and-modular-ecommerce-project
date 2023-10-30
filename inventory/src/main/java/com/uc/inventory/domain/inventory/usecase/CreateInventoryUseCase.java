package com.uc.inventory.domain.inventory.usecase;

import com.uc.common.usecase.UseCase;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateInventoryUseCase implements UseCase {
    private Long productId;
    private Long amount;
}
