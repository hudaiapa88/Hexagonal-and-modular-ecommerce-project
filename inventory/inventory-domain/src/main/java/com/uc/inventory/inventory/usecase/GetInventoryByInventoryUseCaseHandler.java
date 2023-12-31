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
public class GetInventoryByInventoryUseCaseHandler implements UseCaseHandler<Inventory, GetInventoryByInventoryIdUseCase> {

    private final InventoryPort inventoryPort;
    @Override
    public Inventory handle(GetInventoryByInventoryIdUseCase value) {
        return inventoryPort.getById(value.getId());
    }
}
