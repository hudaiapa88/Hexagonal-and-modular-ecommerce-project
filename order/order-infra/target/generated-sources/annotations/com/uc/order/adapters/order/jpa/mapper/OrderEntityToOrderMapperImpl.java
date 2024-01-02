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
    date = "2023-12-31T14:41:09+0300",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.3 (Amazon.com Inc.)"
)
@Component
public class OrderEntityToOrderMapperImpl implements OrderEntityToOrderMapper {

    @Override
    public Order convert(OrderEntity input) {
        if ( input == null ) {
            return null;
        }

        Order order = new Order();

        order.setId( input.getId() );
        order.setCreatedDateTime( input.getCreatedDateTime() );
        order.setUpdatedDateTime( input.getUpdatedDateTime() );
        order.setAddress( addressEntityToAddress( input.getAddress() ) );
        order.setTotalPrice( input.getTotalPrice() );

        return order;
    }

    @Override
    public List<Order> convertList(List<OrderEntity> inputList) {
        if ( inputList == null ) {
            return null;
        }

        List<Order> list = new ArrayList<Order>( inputList.size() );
        for ( OrderEntity orderEntity : inputList ) {
            list.add( convert( orderEntity ) );
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
}
