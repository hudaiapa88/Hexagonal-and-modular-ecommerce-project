package com.uc.order.adapters.orderLine.rest.mapper;


import com.uc.order.adapters.orderLine.rest.response.OrderLineResponse;
import com.uc.order.common.mapper.BaseMapper;
import com.uc.order.orderline.model.OrderLine;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OrderLineToOrderLineResponseMapper extends BaseMapper<OrderLine, OrderLineResponse> {
}
