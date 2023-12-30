package com.uc.order.infra.adapters.order.rest.mapper;

import com.uc.order.domain.order.model.Order;
import com.uc.order.infra.adapters.order.rest.response.OrderResponse;
import com.uc.order.infra.common.mapper.BaseMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OrderToOrderResponseMapper extends BaseMapper<Order, OrderResponse> {
}
