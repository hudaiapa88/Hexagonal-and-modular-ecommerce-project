package com.uc.inventory.domain.inventory.usecase;

import com.uc.common.DomainComponent;
import com.uc.common.usecase.VoidUseCaseHandler;
import com.uc.inventory.domain.inventory.model.Inventory;
import com.uc.inventory.domain.inventory.port.InventoryPort;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@DomainComponent
@RequiredArgsConstructor
public class IncreaseInventoryUseCaseHandler implements VoidUseCaseHandler<IncreaseInventoryUseCase> {

    private final InventoryPort inventoryPort;
    @Override
    public void handle(IncreaseInventoryUseCase value) {
        Inventory inventory= inventoryPort.getById(value.getId());
        Long amount= inventory.getAmount();
        amount+= value.getAmount();
        inventory.setAmount(amount);
        inventoryPort.save(inventory);
    }
}
