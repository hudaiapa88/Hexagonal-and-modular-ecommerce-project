package com.uc.inventory.infra.adapters.inventory.jpa.repository;

import com.uc.inventory.infra.adapters.inventory.jpa.entity.InventoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface InventoryRepository extends JpaRepository<InventoryEntity,Long> {
   Optional<InventoryEntity>  findByProductId(Long productId);
}
