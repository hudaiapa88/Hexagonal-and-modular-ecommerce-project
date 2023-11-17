package com.uc.inventory.infra.adapters.inventory.mapper;

import com.uc.common.mapper.BaseMapper;
import com.uc.inventory.domain.inventory.model.Inventory;
import com.uc.inventory.infra.adapters.inventory.rest.response.InventoryResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface InventoryToInventoryResponseMapper extends BaseMapper<Inventory, InventoryResponse> {
}
