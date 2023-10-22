package com.uc.order.infra.adapters.order.mapper;

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
    date = "2023-10-23T01:48:55+0300",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.3 (Amazon.com Inc.)"
)
*/
@Component
public class OrderEntityToOrderMapperImpl implements OrderEntityToOrderMapper {

    @Override
    public Order convert(OrderEntity entity) {
        if ( entity == null ) {
            return null;
        }

        Order order = new Order();

        order.setId( entity.getId() );
        order.setCreatedDateTime( entity.getCreatedDateTime() );
        order.setUpdatedDateTime( entity.getUpdatedDateTime() );
        order.setOrderLines( orderLineEntityListToOrderLineList( entity.getOrderLines() ) );
        order.setAddress( addressEntityToAddress( entity.getAddress() ) );
        order.setTotalPrice( entity.getTotalPrice() );

        return order;
    }

    @Override
    public List<Order> convertList(List<OrderEntity> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<Order> list = new ArrayList<Order>( entityList.size() );
        for ( OrderEntity orderEntity : entityList ) {
            list.add( convert( orderEntity ) );
        }

        return list;
    }

    protected List<OrderLine> orderLineEntityListToOrderLineList(List<OrderLineEntity> list) {
        if ( list == null ) {
            return null;
        }

        List<OrderLine> list1 = new ArrayList<OrderLine>( list.size() );
        for ( OrderLineEntity orderLineEntity : list ) {
            list1.add( orderLineEntityToOrderLine( orderLineEntity ) );
        }

        return list1;
    }

    protected Address addressEntityToAddress(AddressEntity addressEntity) {
        if ( addressEntity == null ) {
            return null;
        }

        Address address = new Address();

        address.setCountry( addressEntity.getCountry() );
        address.setProvince( addressEntity.getProvince() );
        address.setDistrict( addressEntity.getDistrict() );
        address.setNeighborhood( addressEntity.getNeighborhood() );
        address.setStreet( addressEntity.getStreet() );
        address.setBuildingInformation( addressEntity.getBuildingInformation() );
        address.setFullAddress( addressEntity.getFullAddress() );

        return address;
    }

    protected Order orderEntityToOrder(OrderEntity orderEntity) {
        if ( orderEntity == null ) {
            return null;
        }

        Order order = new Order();

        order.setId( orderEntity.getId() );
        order.setCreatedDateTime( orderEntity.getCreatedDateTime() );
        order.setUpdatedDateTime( orderEntity.getUpdatedDateTime() );
        order.setOrderLines( orderLineEntityListToOrderLineList( orderEntity.getOrderLines() ) );
        order.setAddress( addressEntityToAddress( orderEntity.getAddress() ) );
        order.setTotalPrice( orderEntity.getTotalPrice() );

        return order;
    }

    protected OrderLine orderLineEntityToOrderLine(OrderLineEntity orderLineEntity) {
        if ( orderLineEntity == null ) {
            return null;
        }

        OrderLine orderLine = new OrderLine();

        orderLine.setId( orderLineEntity.getId() );
        orderLine.setQuantity( orderLineEntity.getQuantity() );
        orderLine.setProductId( orderLineEntity.getProductId() );
        orderLine.setTotalPrice( orderLineEntity.getTotalPrice() );
        orderLine.setOrder( orderEntityToOrder( orderLineEntity.getOrder() ) );

        return orderLine;
    }
}
