package com.uc.inventory.infra.adapters.inventory.mapper;

import com.uc.inventory.domain.inventory.model.Inventory;
import com.uc.inventory.infra.adapters.inventory.rest.response.InventoryResponse;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

/*
@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-11-29T13:01:21+0300",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.3 (Amazon.com Inc.)"
)
*/
@Component
public class InventoryToInventoryResponseMapperImpl implements InventoryToInventoryResponseMapper {

    @Override
    public InventoryResponse convert(Inventory input) {
        if ( input == null ) {
            return null;
        }

        InventoryResponse inventoryResponse = new InventoryResponse();

        inventoryResponse.setId( input.getId() );
        inventoryResponse.setProductId( input.getProductId() );
        inventoryResponse.setAmount( input.getAmount() );

        return inventoryResponse;
    }

    @Override
    public List<InventoryResponse> convertList(List<Inventory> inputList) {
        if ( inputList == null ) {
            return null;
        }

        List<InventoryResponse> list = new ArrayList<InventoryResponse>( inputList.size() );
        for ( Inventory inventory : inputList ) {
            list.add( convert( inventory ) );
        }

        return list;
    }
}
