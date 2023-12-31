package com.uc.inventory.inventory.usecase;

import com.uc.inventory.common.DomainComponent;
import com.uc.inventory.common.usecase.VoidUseCaseHandler;
import com.uc.inventory.inventory.port.InventoryPort;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@DomainComponent
@RequiredArgsConstructor
public class DeleteInventoryUseCaseHandler implements VoidUseCaseHandler<DeleteInventoryUseCase> {
  private final InventoryPort inventoryPort;

    @Override
    public void handle(DeleteInventoryUseCase value) {
     inventoryPort.delete(value);
    }
}
