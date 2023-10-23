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
    date = "2023-10-24T00:48:51+0300",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.3 (Amazon.com Inc.)"
)
*/
@Component
public class OrderLineEntityToOrderLineMapperImpl implements OrderLineEntityToOrderLineMapper {

    @Override
    public OrderLine convert(OrderLineEntity entity) {
        if ( entity == null ) {
            return null;
        }

        OrderLine orderLine = new OrderLine();

        orderLine.setId( entity.getId() );
        orderLine.setQuantity( entity.getQuantity() );
        orderLine.setProductId( entity.getProductId() );
        orderLine.setTotalPrice( entity.getTotalPrice() );
        orderLine.setOrder( orderEntityToOrder( entity.getOrder() ) );

        return orderLine;
    }

    @Override
    public List<OrderLine> convertList(List<OrderLineEntity> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<OrderLine> list = new ArrayList<OrderLine>( entityList.size() );
        for ( OrderLineEntity orderLineEntity : entityList ) {
            list.add( convert( orderLineEntity ) );
        }

        return list;
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
        order.setAddress( addressEntityToAddress( orderEntity.getAddress() ) );
        order.setTotalPrice( orderEntity.getTotalPrice() );

        return order;
    }
}
