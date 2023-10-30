package com.uc.inventory.infra.adapters.inventory.jpa.repository;

import com.uc.inventory.infra.adapters.inventory.jpa.entity.InventoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryRepository extends JpaRepository<InventoryEntity,Long> {
}
