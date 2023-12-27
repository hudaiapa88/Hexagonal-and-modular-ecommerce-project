package com.uc.inventory.domain.inventory.usecase;

import  com.uc.inventory.domain.common.DomainComponent;
import com.uc.inventory.domain.common.usecase.ObservableUseCasePublisherInventory;
import com.uc.inventory.domain.common.usecase.VoidUseCaseHandler;
import com.uc.inventory.domain.inventory.model.Inventory;
import com.uc.inventory.domain.inventory.port.InventoryPort;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@DomainComponent
public class DecreaseInventoryUseCaseHandlerInventory extends ObservableUseCasePublisherInventory implements VoidUseCaseHandler<DecreaseInventoryUseCase> {

    private final InventoryPort inventoryPort;
    public DecreaseInventoryUseCaseHandlerInventory(InventoryPort inventoryPort){
        this.inventoryPort=inventoryPort;
        register(DecreaseInventoryUseCase.class,this);
    }
    @Override
    public void handle(DecreaseInventoryUseCase value) {
        Inventory inventory= inventoryPort.getByProductId(value.getProductId());
        Long amount= inventory.getAmount();
        amount-= value.getAmount();
        inventory.setAmount(amount);
        inventoryPort.save(inventory);
    }
}
