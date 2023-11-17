package com.uc.order.domain.orderline.port;

import com.uc.order.domain.order.usecase.GetOrderByOrderIdUseCase;
import com.uc.order.domain.orderline.model.OrderLine;
import com.uc.order.domain.orderline.usecase.DeleteOrderLineUseCase;

import java.util.List;

public interface OrderLinePort {
     OrderLine save(OrderLine orderLine);
     List<OrderLine> getByOrderId(GetOrderByOrderIdUseCase value);
     void delete(DeleteOrderLineUseCase deleteOrderLineUseCase);
}
