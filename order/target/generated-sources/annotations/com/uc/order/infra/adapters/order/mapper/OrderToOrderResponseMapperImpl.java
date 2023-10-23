package com.uc.order.infra.adapters.order.mapper;

import com.uc.order.domain.order.model.Address;
import com.uc.order.domain.order.model.Order;
import com.uc.order.infra.adapters.order.rest.response.AddressResponse;
import com.uc.order.infra.adapters.order.rest.response.OrderResponse;
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
public class OrderToOrderResponseMapperImpl implements OrderToOrderResponseMapper {

    @Override
    public OrderResponse convert(Order entity) {
        if ( entity == null ) {
            return null;
        }

        OrderResponse orderResponse = new OrderResponse();

        orderResponse.setTotalPrice( entity.getTotalPrice() );
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
