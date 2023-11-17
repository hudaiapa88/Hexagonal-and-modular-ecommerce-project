package com.uc.inventory.domain.inventory.usecase;

import com.uc.common.DomainComponent;
import com.uc.common.usecase.ObservableUseCasePublisher;
import com.uc.common.usecase.UseCaseHandler;
import com.uc.common.usecase.VoidUseCaseHandler;
import com.uc.inventory.domain.inventory.model.Inventory;
import com.uc.inventory.domain.inventory.port.InventoryPort;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@DomainComponent
public class DecreaseInventoryUseCaseHandler extends ObservableUseCasePublisher implements  VoidUseCaseHandler<DecreaseInventoryUseCase> {

    private final InventoryPort inventoryPort;
    public DecreaseInventoryUseCaseHandler(InventoryPort inventoryPort){
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
