package com.uc.inventory.infra.adapters.inventory.jpa.mapper;

import com.uc.inventory.domain.inventory.model.Inventory;
import com.uc.inventory.infra.adapters.inventory.jpa.entity.InventoryEntity;
import com.uc.inventory.infra.common.mapper.BaseMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface InventoryToInventoryEntityMapper extends BaseMapper<Inventory, InventoryEntity> {
}
