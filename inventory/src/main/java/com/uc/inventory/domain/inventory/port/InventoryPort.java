package com.uc.inventory.domain.inventory.port;

import com.uc.inventory.domain.inventory.model.Inventory;
import com.uc.inventory.domain.inventory.usecase.DeleteInventoryUseCase;
import com.uc.inventory.domain.inventory.usecase.GetInventoryByProductIdUseCase;

import java.util.List;

public interface InventoryPort {
    Inventory save(Inventory inventory);

    Inventory getById(Long id);

    void delete(DeleteInventoryUseCase value);

    List<Inventory> getAll();

    Inventory getByProductId(GetInventoryByProductIdUseCase value);
    Inventory getByProductId(Long productId);
}
