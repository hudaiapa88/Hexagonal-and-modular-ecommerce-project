package com.uc.inventory.adapters.inventory.rest.mapper;

import com.uc.inventory.adapters.inventory.rest.response.InventoryResponse;
import com.uc.inventory.inventory.model.Inventory;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-12-31T14:33:03+0300",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.3 (Amazon.com Inc.)"
)
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
