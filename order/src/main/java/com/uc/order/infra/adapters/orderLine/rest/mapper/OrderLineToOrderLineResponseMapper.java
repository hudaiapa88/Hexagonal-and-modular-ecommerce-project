package com.uc.order.infra.adapters.orderLine.rest.mapper;


import com.uc.order.domain.orderline.model.OrderLine;
import com.uc.order.infra.adapters.orderLine.rest.response.OrderLineResponse;
import com.uc.order.infra.common.mapper.BaseMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OrderLineToOrderLineResponseMapper extends BaseMapper<OrderLine, OrderLineResponse> {
}
