package com.uc.order.infra.adapters.orderLine.mapper;

import com.uc.order.domain.orderline.model.OrderLine;
import com.uc.order.infra.adapters.orderLine.rest.response.OrderLineResponse;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

/*
@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-11-29T13:00:39+0300",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.3 (Amazon.com Inc.)"
)
*/
@Component
public class OrderLineToOrderLineResponseMapperImpl implements OrderLineToOrderLineResponseMapper {

    @Override
    public OrderLineResponse convert(OrderLine input) {
        if ( input == null ) {
            return null;
        }

        OrderLineResponse orderLineResponse = new OrderLineResponse();

        orderLineResponse.setProductId( input.getProductId() );
        orderLineResponse.setQuantity( input.getQuantity() );
        orderLineResponse.setTotalPrice( input.getTotalPrice() );

        return orderLineResponse;
    }

    @Override
    public List<OrderLineResponse> convertList(List<OrderLine> inputList) {
        if ( inputList == null ) {
            return null;
        }

        List<OrderLineResponse> list = new ArrayList<OrderLineResponse>( inputList.size() );
        for ( OrderLine orderLine : inputList ) {
            list.add( convert( orderLine ) );
        }

        return list;
    }
}
