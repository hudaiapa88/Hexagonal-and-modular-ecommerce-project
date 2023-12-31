package com.uc.order.adapters.order.rest.mapper;

import com.uc.order.adapters.order.rest.response.OrderResponse;
import com.uc.order.common.mapper.BaseMapper;
import com.uc.order.order.model.Order;


import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OrderToOrderResponseMapper extends BaseMapper<Order, OrderResponse> {
}
