package com.uc.inventory.domain.inventory.port;

import com.uc.inventory.domain.inventory.model.Inventory;

public interface InventoryPort {
    Inventory save(Inventory inventory);
}
