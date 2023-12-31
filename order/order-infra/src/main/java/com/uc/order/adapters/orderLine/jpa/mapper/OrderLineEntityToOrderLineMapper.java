package com.uc.order.adapters.orderLine.jpa.mapper;

import com.uc.order.adapters.orderLine.jpa.entity.OrderLineEntity;
import com.uc.order.common.mapper.BaseMapper;
import com.uc.order.orderline.model.OrderLine;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OrderLineEntityToOrderLineMapper extends BaseMapper<OrderLineEntity, OrderLine> {
}
