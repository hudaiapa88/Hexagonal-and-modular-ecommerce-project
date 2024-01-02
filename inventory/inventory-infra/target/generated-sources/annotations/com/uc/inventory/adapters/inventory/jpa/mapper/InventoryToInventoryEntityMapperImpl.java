package com.uc.inventory.adapters.inventory.jpa.mapper;

import com.uc.inventory.adapters.inventory.jpa.entity.InventoryEntity;
import com.uc.inventory.inventory.model.Inventory;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-12-31T14:41:12+0300",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.3 (Amazon.com Inc.)"
)
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
