package com.uc.inventory.inventory.port;

import com.uc.inventory.inventory.model.Inventory;
import com.uc.inventory.inventory.usecase.DeleteInventoryUseCase;
import com.uc.inventory.inventory.usecase.GetInventoryByProductIdUseCase;

import java.util.List;

public interface InventoryPort {
    Inventory save(Inventory inventory);

    Inventory getById(Long id);

    void delete(DeleteInventoryUseCase value);

    List<Inventory> getAll();

    Inventory getByProductId(GetInventoryByProductIdUseCase value);
    Inventory getByProductId(Long productId);
}
