package com.uc.order.adapters.order.jpa.mapper;

import com.uc.order.adapters.order.jpa.entity.AddressEntity;
import com.uc.order.adapters.order.jpa.entity.OrderEntity;
import com.uc.order.order.model.Address;
import com.uc.order.order.model.Order;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-12-31T14:32:49+0300",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.3 (Amazon.com Inc.)"
)
@Component
public class OrderToOrderEntityMapperImpl implements OrderToOrderEntityMapper {

    @Override
    public OrderEntity convert(Order input) {
        if ( input == null ) {
            return null;
        }

        OrderEntity orderEntity = new OrderEntity();

        orderEntity.setId( input.getId() );
        orderEntity.setCreatedDateTime( input.getCreatedDateTime() );
        orderEntity.setUpdatedDateTime( input.getUpdatedDateTime() );
        orderEntity.setAddress( addressToAddressEntity( input.getAddress() ) );
        orderEntity.setTotalPrice( input.getTotalPrice() );

        return orderEntity;
    }

    @Override
    public List<OrderEntity> convertList(List<Order> inputList) {
        if ( inputList == null ) {
            return null;
        }

        List<OrderEntity> list = new ArrayList<OrderEntity>( inputList.size() );
        for ( Order order : inputList ) {
            list.add( convert( order ) );
        }

        return list;
    }

    protected AddressEntity addressToAddressEntity(Address address) {
        if ( address == null ) {
            return null;
        }

        AddressEntity addressEntity = new AddressEntity();

        addressEntity.setCountry( address.getCountry() );
        addressEntity.setProvince( address.getProvince() );
        addressEntity.setDistrict( address.getDistrict() );
        addressEntity.setNeighborhood( address.getNeighborhood() );
        addressEntity.setStreet( address.getStreet() );
        addressEntity.setBuildingInformation( address.getBuildingInformation() );
        addressEntity.setFullAddress( address.getFullAddress() );

        return addressEntity;
    }
}
