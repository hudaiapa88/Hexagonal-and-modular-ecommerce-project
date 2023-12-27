package com.uc.order.infra.adapters.orderLine.mapper;

import com.uc.order.domain.orderline.model.OrderLine;
import com.uc.order.infra.adapters.orderLine.jpa.entity.OrderLineEntity;
import com.uc.order.infra.common.mapper.BaseMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OrderLineToOrderLineEntityMapper extends BaseMapper<OrderLine, OrderLineEntity> {
}
