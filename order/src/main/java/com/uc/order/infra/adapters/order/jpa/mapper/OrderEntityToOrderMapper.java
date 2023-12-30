package com.uc.order.infra.adapters.order.jpa.mapper;

import com.uc.order.domain.order.model.Order;
import com.uc.order.infra.adapters.order.jpa.entity.OrderEntity;
import com.uc.order.infra.common.mapper.BaseMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OrderEntityToOrderMapper extends BaseMapper<OrderEntity, Order> {
}
