package com.uc.inventory.adapters.inventory.rest.mapper;

import com.uc.inventory.adapters.inventory.rest.response.InventoryResponse;
import com.uc.inventory.common.mapper.BaseMapper;
import com.uc.inventory.inventory.model.Inventory;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface InventoryToInventoryResponseMapper extends BaseMapper<Inventory, InventoryResponse> {
}
