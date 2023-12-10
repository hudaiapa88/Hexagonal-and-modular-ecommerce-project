package com.uc.inventory.infra.adapters.inventory.mapper;

import com.uc.inventory.domain.inventory.model.Inventory;
import com.uc.inventory.infra.adapters.inventory.jpa.entity.InventoryEntity;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

/*
@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-12-11T00:49:57+0300",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.3 (Amazon.com Inc.)"
)
*/
@Component
public class InventoryEntityToInventoryMapperImpl implements InventoryEntityToInventoryMapper {

    @Override
    public Inventory convert(InventoryEntity input) {
        if ( input == null ) {
            return null;
        }

        Inventory inventory = new Inventory();

        inventory.setId( input.getId() );
        inventory.setProductId( input.getProductId() );
        inventory.setAmount( input.getAmount() );

        return inventory;
    }

    @Override
    public List<Inventory> convertList(List<InventoryEntity> inputList) {
        if ( inputList == null ) {
            return null;
        }

        List<Inventory> list = new ArrayList<Inventory>( inputList.size() );
        for ( InventoryEntity inventoryEntity : inputList ) {
            list.add( convert( inventoryEntity ) );
        }

        return list;
    }
}
