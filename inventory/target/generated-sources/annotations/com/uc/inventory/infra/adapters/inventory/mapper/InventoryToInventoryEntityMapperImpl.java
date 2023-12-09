package com.uc.inventory.infra.adapters.inventory.mapper;

import com.uc.inventory.domain.inventory.model.Inventory;
import com.uc.inventory.infra.adapters.inventory.jpa.entity.InventoryEntity;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

/*
@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-12-09T16:17:40+0300",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.3 (Amazon.com Inc.)"
)
*/
@Component
public class InventoryToInventoryEntityMapperImpl implements InventoryToInventoryEntityMapper {

    @Override
    public InventoryEntity convert(Inventory input) {
        if ( input == null ) {
            return null;
        }

        InventoryEntity inventoryEntity = new InventoryEntity();

        inventoryEntity.setId( input.getId() );
        inventoryEntity.setProductId( input.getProductId() );
        inventoryEntity.setAmount( input.getAmount() );

        return inventoryEntity;
    }

    @Override
    public List<InventoryEntity> convertList(List<Inventory> inputList) {
        if ( inputList == null ) {
            return null;
        }

        List<InventoryEntity> list = new ArrayList<InventoryEntity>( inputList.size() );
        for ( Inventory inventory : inputList ) {
            list.add( convert( inventory ) );
        }

        return list;
    }
}
