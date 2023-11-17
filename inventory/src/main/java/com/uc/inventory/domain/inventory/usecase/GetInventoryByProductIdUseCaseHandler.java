package com.uc.inventory.domain.inventory.usecase;

import com.uc.common.DomainComponent;
import com.uc.common.usecase.UseCaseHandler;
import com.uc.inventory.domain.inventory.model.Inventory;
import com.uc.inventory.domain.inventory.port.InventoryPort;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@DomainComponent
@RequiredArgsConstructor

public class GetInventoryByProductIdUseCaseHandler implements UseCaseHandler<Inventory, GetInventoryByProductIdUseCase> {

   private final InventoryPort inventoryPort;
    @Override
    public Inventory handle(GetInventoryByProductIdUseCase value) {
        return inventoryPort.getByProductId(value);
    }
}
