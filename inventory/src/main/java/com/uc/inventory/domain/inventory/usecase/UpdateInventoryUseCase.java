package com.uc.inventory.domain.inventory.usecase;

import com.uc.common.usecase.UseCase;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateInventoryUseCase implements UseCase {
    private Long id;
    private Long amount;
}