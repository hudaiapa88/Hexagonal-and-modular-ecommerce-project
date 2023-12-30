package com.uc.order.infra.adapters.orderLine.mapper;

import com.uc.order.domain.order.model.Address;
import com.uc.order.domain.order.model.Order;
import com.uc.order.domain.orderline.model.OrderLine;
import com.uc.order.infra.adapters.order.jpa.entity.AddressEntity;
import com.uc.order.infra.adapters.order.jpa.entity.OrderEntity;
import com.uc.order.infra.adapters.orderLine.jpa.entity.OrderLineEntity;
import java.util.ArrayList;
import java.util.List;

import com.uc.order.infra.adapters.orderLine.jpa.mapper.OrderLineEntityToOrderLineMapper;
import org.springframework.stereotype.Component;

/*
@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-12-29T16:17:37+0300",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.3 (Amazon.com Inc.)"
)
*/
@Component
public class OrderLineEntityToOrderLineMapperImpl implements OrderLineEntityToOrderLineMapper {

    @Override
    public OrderLine convert(OrderLineEntity input) {
        if ( input == null ) {
            return null;
        }

        OrderLine orderLine = new OrderLine();

        orderLine.setId( input.getId() );
        orderLine.setQuantity( input.getQuantity() );
        orderLine.setProductId( input.getProductId() );
        orderLine.setTotalPrice( input.getTotalPrice() );
        orderLine.setOrder( orderEntityToOrder( input.getOrder() ) );

        return orderLine;
    }

    @Override
    public List<OrderLine> convertList(List<OrderLineEntity> inputList) {
        if ( inputList == null ) {
            return null;
        }

        List<OrderLine> list = new ArrayList<OrderLine>( inputList.size() );
        for ( OrderLineEntity orderLineEntity : inputList ) {
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
