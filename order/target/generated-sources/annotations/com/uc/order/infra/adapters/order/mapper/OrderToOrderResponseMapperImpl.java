package com.uc.order.infra.adapters.order.mapper;

import com.uc.order.domain.order.model.Address;
import com.uc.order.domain.order.model.Order;
import com.uc.order.domain.orderline.model.OrderLine;
import com.uc.order.infra.adapters.order.rest.response.AddressResponse;
import com.uc.order.infra.adapters.order.rest.response.OrderResponse;
import com.uc.order.infra.adapters.orderLine.rest.response.OrderLineResponse;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

/*
@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-10-23T01:48:56+0300",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.3 (Amazon.com Inc.)"
)
*/
@Component
public class OrderToOrderResponseMapperImpl implements OrderToOrderResponseMapper {

    @Override
    public OrderResponse convert(Order entity) {
        if ( entity == null ) {
            return null;
        }

        OrderResponse orderResponse = new OrderResponse();

        orderResponse.setTotalPrice( entity.getTotalPrice() );
        orderResponse.setOrderLines( orderLineListToOrderLineResponseList( entity.getOrderLines() ) );
        orderResponse.setAddress( addressToAddressResponse( entity.getAddress() ) );

        return orderResponse;
    }

    @Override
    public List<OrderResponse> convertList(List<Order> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<OrderResponse> list = new ArrayList<OrderResponse>( entityList.size() );
        for ( Order order : entityList ) {
            list.add( convert( order ) );
        }

        return list;
    }

    protected OrderLineResponse orderLineToOrderLineResponse(OrderLine orderLine) {
        if ( orderLine == null ) {
            return null;
        }

        OrderLineResponse orderLineResponse = new OrderLineResponse();

        orderLineResponse.setProductId( orderLine.getProductId() );
        orderLineResponse.setQuantity( orderLine.getQuantity() );
        orderLineResponse.setTotalPrice( orderLine.getTotalPrice() );

        return orderLineResponse;
    }

    protected List<OrderLineResponse> orderLineListToOrderLineResponseList(List<OrderLine> list) {
        if ( list == null ) {
            return null;
        }

        List<OrderLineResponse> list1 = new ArrayList<OrderLineResponse>( list.size() );
        for ( OrderLine orderLine : list ) {
            list1.add( orderLineToOrderLineResponse( orderLine ) );
        }

        return list1;
    }

    protected AddressResponse addressToAddressResponse(Address address) {
        if ( address == null ) {
            return null;
        }

        AddressResponse addressResponse = new AddressResponse();

        addressResponse.setCountry( address.getCountry() );
        addressResponse.setProvince( address.getProvince() );
        addressResponse.setDistrict( address.getDistrict() );
        addressResponse.setNeighborhood( address.getNeighborhood() );
        addressResponse.setStreet( address.getStreet() );
        addressResponse.setBuildingInformation( address.getBuildingInformation() );
        addressResponse.setFullAddress( address.getFullAddress() );

        return addressResponse;
    }
}
