package com.uc.inventory.inventory.usecase;

import com.uc.inventory.common.DomainComponent;
import com.uc.inventory.common.usecase.NoUseCaseHandler;
import com.uc.inventory.inventory.model.Inventory;
import com.uc.inventory.inventory.port.InventoryPort;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
@DomainComponent
@RequiredArgsConstructor
public class GetAllInventoryUseCaseHandler implements NoUseCaseHandler<List<Inventory>> {

    private final InventoryPort inventoryPort;
    @Override
    public List<Inventory> handle() {
        return inventoryPort.getAll();
    }
}
