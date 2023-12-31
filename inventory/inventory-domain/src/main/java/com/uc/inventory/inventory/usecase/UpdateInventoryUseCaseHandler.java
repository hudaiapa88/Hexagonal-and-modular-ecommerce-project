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
public class UpdateInventoryUseCaseHandler implements UseCaseHandler<Inventory, UpdateInventoryUseCase> {

    private final InventoryPort inventoryPort;
    @Override
    public Inventory handle(UpdateInventoryUseCase value) {
        Inventory inventory= inventoryPort.getById(value.getId());
        inventory.setAmount(value.getAmount());
        return inventoryPort.save(inventory);
    }
}
