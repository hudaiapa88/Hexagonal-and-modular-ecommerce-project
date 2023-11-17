package com.uc.inventory.infra.adapters.inventory;


import com.uc.common.rest.exception.EntityNotFoundException;
import com.uc.inventory.domain.inventory.model.Inventory;
import com.uc.inventory.domain.inventory.port.InventoryPort;
import com.uc.inventory.domain.inventory.usecase.DeleteInventoryUseCase;
import com.uc.inventory.domain.inventory.usecase.GetInventoryByProductIdUseCase;
import com.uc.inventory.infra.adapters.inventory.jpa.entity.InventoryEntity;
import com.uc.inventory.infra.adapters.inventory.jpa.repository.InventoryRepository;
import com.uc.inventory.infra.adapters.inventory.mapper.InventoryEntityToInventoryMapper;
import com.uc.inventory.infra.adapters.inventory.mapper.InventoryToInventoryEntityMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InventoryAdapter implements InventoryPort {
    private final InventoryRepository inventoryRepository;
    private final InventoryEntityToInventoryMapper inventoryEntityToInventoryMapper;
    private final InventoryToInventoryEntityMapper inventoryToInventoryEntityMapper;

    @Override
    public Inventory save(Inventory inventory) {
        InventoryEntity inventoryEntity=inventoryToInventoryEntityMapper.convert(inventory);
        return inventoryEntityToInventoryMapper.convert(inventoryRepository.save(inventoryEntity));
    }

    @Override
    public Inventory getById(Long id) {
        return inventoryEntityToInventoryMapper.convert(findById(id));
    }

    @Override
    public void delete(DeleteInventoryUseCase value) {
        inventoryRepository.deleteById(value.getId());
    }

    @Override
    public List<Inventory> getAll() {
        return inventoryEntityToInventoryMapper.convertList(inventoryRepository.findAll());
    }

    @Override
    public Inventory getByProductId(GetInventoryByProductIdUseCase value) {
        return inventoryEntityToInventoryMapper.convert(findByProductId(value.getProductId()));
    }

    @Override
    public Inventory getByProductId(Long productId) {
        return inventoryEntityToInventoryMapper.convert(findByProductId(productId));
    }

    private InventoryEntity findByProductId(Long productId) {
        return inventoryRepository.findByProductId(productId).orElseThrow(()->new EntityNotFoundException("Ürüne ait stok bulunamadı"));
    }

    private InventoryEntity findById(Long id) {
        return inventoryRepository.findById(id).orElseThrow(()->new EntityNotFoundException("Stok bulunamadı"));
    }
}
