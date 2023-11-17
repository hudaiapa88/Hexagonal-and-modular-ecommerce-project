package com.uc.inventory.infra.adapters.inventory.mapper;

import com.uc.common.mapper.BaseMapper;
import com.uc.inventory.domain.inventory.model.Inventory;
import com.uc.inventory.infra.adapters.inventory.jpa.entity.InventoryEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface InventoryToInventoryEntityMapper extends BaseMapper<Inventory, InventoryEntity> {
}
