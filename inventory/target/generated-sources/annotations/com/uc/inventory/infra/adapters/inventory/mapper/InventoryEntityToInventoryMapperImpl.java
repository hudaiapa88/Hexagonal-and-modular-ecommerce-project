package com.uc.inventory.infra.adapters.inventory.mapper;

import com.uc.inventory.domain.inventory.model.Inventory;
import com.uc.inventory.infra.adapters.inventory.jpa.entity.InventoryEntity;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

/*
@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-11-20T01:04:58+0300",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.3 (Amazon.com Inc.)"
)
*/
@Component
public class InventoryEntityToInventoryMapperImpl implements InventoryEntityToInventoryMapper {

    @Override
    public Inventory convert(InventoryEntity entity) {
        if ( entity == null ) {
            return null;
        }

        Inventory inventory = new Inventory();

        inventory.setId( entity.getId() );
        inventory.setProductId( entity.getProductId() );
        inventory.setAmount( entity.getAmount() );

        return inventory;
    }

    @Override
    public List<Inventory> convertList(List<InventoryEntity> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<Inventory> list = new ArrayList<Inventory>( entityList.size() );
        for ( InventoryEntity inventoryEntity : entityList ) {
            list.add( convert( inventoryEntity ) );
        }

        return list;
    }
}
