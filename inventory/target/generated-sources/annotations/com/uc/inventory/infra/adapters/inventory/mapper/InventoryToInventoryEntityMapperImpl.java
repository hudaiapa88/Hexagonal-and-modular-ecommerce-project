package com.uc.inventory.infra.adapters.inventory.mapper;

import com.uc.inventory.domain.inventory.model.Inventory;
import com.uc.inventory.infra.adapters.inventory.jpa.entity.InventoryEntity;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

/*
@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-11-17T03:29:11+0300",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.3 (Amazon.com Inc.)"
)
*/
@Component
public class InventoryToInventoryEntityMapperImpl implements InventoryToInventoryEntityMapper {

    @Override
    public InventoryEntity convert(Inventory entity) {
        if ( entity == null ) {
            return null;
        }

        InventoryEntity inventoryEntity = new InventoryEntity();

        inventoryEntity.setId( entity.getId() );
        inventoryEntity.setProductId( entity.getProductId() );
        inventoryEntity.setAmount( entity.getAmount() );

        return inventoryEntity;
    }

    @Override
    public List<InventoryEntity> convertList(List<Inventory> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<InventoryEntity> list = new ArrayList<InventoryEntity>( entityList.size() );
        for ( Inventory inventory : entityList ) {
            list.add( convert( inventory ) );
        }

        return list;
    }
}
