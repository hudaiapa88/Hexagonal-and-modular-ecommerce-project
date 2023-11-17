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
public class UpdateInventoryUseCaseHandler implements UseCaseHandler<Inventory, UpdateInventoryUseCase> {

    private final InventoryPort inventoryPort;
    @Override
    public Inventory handle(UpdateInventoryUseCase value) {
        Inventory inventory= inventoryPort.getById(value.getId());
        inventory.setAmount(value.getAmount());
        return inventoryPort.save(inventory);
    }
}
