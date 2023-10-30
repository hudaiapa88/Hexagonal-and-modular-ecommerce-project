package com.uc.inventory.infra.adapters.inventory;

import com.uc.inventory.domain.inventory.model.Inventory;
import com.uc.inventory.domain.inventory.port.InventoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InventoryAdapter implements InventoryPort {
    @Override
    public Inventory save(Inventory inventory) {
        return null;
    }
}
