package com.uc.order.adapters.orderLine.rest.mapper;

import com.uc.order.adapters.orderLine.rest.response.OrderLineResponse;
import com.uc.order.orderline.model.OrderLine;
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
