package com.uc.inventory.infra.adapters.inventory.mapper;

import com.uc.inventory.domain.inventory.model.Inventory;
import com.uc.inventory.infra.adapters.inventory.rest.response.InventoryResponse;
import com.uc.inventory.infra.common.mapper.BaseMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface InventoryToInventoryResponseMapper extends BaseMapper<Inventory, InventoryResponse> {
}
