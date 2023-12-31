package com.uc.inventory.adapters.inventory.jpa.mapper;

import com.uc.inventory.adapters.inventory.jpa.entity.InventoryEntity;
import com.uc.inventory.common.mapper.BaseMapper;
import com.uc.inventory.inventory.model.Inventory;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface InventoryToInventoryEntityMapper extends BaseMapper<Inventory, InventoryEntity> {
}
