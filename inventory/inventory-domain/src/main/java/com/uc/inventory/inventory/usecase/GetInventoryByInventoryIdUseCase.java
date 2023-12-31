package com.uc.inventory.inventory.usecase;

import com.uc.inventory.common.usecase.UseCase;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class GetInventoryByInventoryIdUseCase implements UseCase {
    private Long id;
}
