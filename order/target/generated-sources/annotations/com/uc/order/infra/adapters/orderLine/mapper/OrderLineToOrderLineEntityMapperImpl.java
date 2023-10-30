package com.uc.order.infra.adapters.orderLine.mapper;

import com.uc.order.domain.order.model.Address;
import com.uc.order.domain.order.model.Order;
import com.uc.order.domain.orderline.model.OrderLine;
import com.uc.order.infra.adapters.order.jpa.entity.AddressEntity;
import com.uc.order.infra.adapters.order.jpa.entity.OrderEntity;
import com.uc.order.infra.adapters.orderLine.jpa.entity.OrderLineEntity;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

/*
@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-10-30T15:26:52+0300",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.3 (Amazon.com Inc.)"
)
*/
@Component
public class OrderLineToOrderLineEntityMapperImpl implements OrderLineToOrderLineEntityMapper {

    @Override
    public OrderLineEntity convert(OrderLine entity) {
        if ( entity == null ) {
            return null;
        }

        OrderLineEntity orderLineEntity = new OrderLineEntity();

        orderLineEntity.setId( entity.getId() );
        orderLineEntity.setQuantity( entity.getQuantity() );
        orderLineEntity.setProductId( entity.getProductId() );
        orderLineEntity.setTotalPrice( entity.getTotalPrice() );
        orderLineEntity.setOrder( orderToOrderEntity( entity.getOrder() ) );

        return orderLineEntity;
    }

    @Override
    public List<OrderLineEntity> convertList(List<OrderLine> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<OrderLineEntity> list = new ArrayList<OrderLineEntity>( entityList.size() );
        for ( OrderLine orderLine : entityList ) {
            list.add( convert( orderLine ) );
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

    protected OrderEntity orderToOrderEntity(Order order) {
        if ( order == null ) {
            return null;
        }

        OrderEntity orderEntity = new OrderEntity();

        orderEntity.setId( order.getId() );
        orderEntity.setCreatedDateTime( order.getCreatedDateTime() );
        orderEntity.setUpdatedDateTime( order.getUpdatedDateTime() );
        orderEntity.setAddress( addressToAddressEntity( order.getAddress() ) );
        orderEntity.setTotalPrice( order.getTotalPrice() );

        return orderEntity;
    }
}
