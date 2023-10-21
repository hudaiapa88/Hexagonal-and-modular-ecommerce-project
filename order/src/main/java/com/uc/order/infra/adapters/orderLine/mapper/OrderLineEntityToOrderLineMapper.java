package com.uc.order.infra.adapters.orderLine.mapper;


import com.uc.common.mapper.BaseMapper;
import com.uc.order.domain.orderline.model.OrderLine;
import com.uc.order.infra.adapters.orderLine.jpa.entity.OrderLineEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OrderLineEntityToOrderLineMapper extends BaseMapper<OrderLineEntity, OrderLine> {
}