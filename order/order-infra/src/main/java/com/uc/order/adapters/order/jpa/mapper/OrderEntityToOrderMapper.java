package com.uc.order.adapters.order.jpa.mapper;


import com.uc.order.adapters.order.jpa.entity.OrderEntity;
import com.uc.order.common.mapper.BaseMapper;
import com.uc.order.order.model.Order;


import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OrderEntityToOrderMapper extends BaseMapper<OrderEntity, Order> {
}
