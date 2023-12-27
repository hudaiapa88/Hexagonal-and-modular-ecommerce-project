package com.uc.inventory.domain.inventory.usecase;

import  com.uc.inventory.domain.common.DomainComponent;
import com.uc.inventory.domain.common.usecase.VoidUseCaseHandler;
import com.uc.inventory.domain.inventory.port.InventoryPort;
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
