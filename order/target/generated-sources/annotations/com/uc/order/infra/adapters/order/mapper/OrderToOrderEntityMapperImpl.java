package com.uc.order.infra.adapters.order.mapper;

import com.uc.order.domain.order.model.Address;
import com.uc.order.domain.order.model.Order;
import com.uc.order.infra.adapters.order.jpa.entity.AddressEntity;
import com.uc.order.infra.adapters.order.jpa.entity.OrderEntity;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

/*
@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-11-17T03:29:08+0300",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.3 (Amazon.com Inc.)"
)
*/
@Component
public class OrderToOrderEntityMapperImpl implements OrderToOrderEntityMapper {

    @Override
    public OrderEntity convert(Order entity) {
        if ( entity == null ) {
            return null;
        }

        OrderEntity orderEntity = new OrderEntity();

        orderEntity.setId( entity.getId() );
        orderEntity.setCreatedDateTime( entity.getCreatedDateTime() );
        orderEntity.setUpdatedDateTime( entity.getUpdatedDateTime() );
        orderEntity.setAddress( addressToAddressEntity( entity.getAddress() ) );
        orderEntity.setTotalPrice( entity.getTotalPrice() );

        return orderEntity;
    }

    @Override
    public List<OrderEntity> convertList(List<Order> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<OrderEntity> list = new ArrayList<OrderEntity>( entityList.size() );
        for ( Order order : entityList ) {
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
