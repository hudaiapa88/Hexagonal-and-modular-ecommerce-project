package com.uc.inventory.domain.inventory.usecase;

import  com.uc.inventory.domain.common.usecase.UseCase;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class GetInventoryByInventoryIdUseCase implements UseCase {
    private Long id;
}
