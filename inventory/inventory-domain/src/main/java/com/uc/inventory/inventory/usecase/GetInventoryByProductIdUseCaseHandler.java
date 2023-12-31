package com.uc.inventory.inventory.usecase;

import com.uc.inventory.common.DomainComponent;
import com.uc.inventory.common.usecase.UseCaseHandler;
import com.uc.inventory.inventory.model.Inventory;
import com.uc.inventory.inventory.port.InventoryPort;
;
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
