package com.uc.order.infra.adapters.order.mapper;

import com.uc.common.mapper.BaseMapper;
import com.uc.order.domain.order.model.Order;
import com.uc.order.infra.adapters.order.jpa.entity.OrderEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OrderToOrderEntityMapper extends BaseMapper<Order, OrderEntity> {
}
