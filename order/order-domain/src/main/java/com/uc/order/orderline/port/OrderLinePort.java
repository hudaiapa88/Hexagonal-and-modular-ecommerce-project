package com.uc.order.orderline.port;

import com.uc.order.order.usecase.GetOrderByOrderIdUseCase;
import com.uc.order.orderline.model.OrderLine;
import com.uc.order.orderline.usecase.DeleteOrderLineUseCase;

import java.util.List;

public interface OrderLinePort {
     OrderLine save(OrderLine orderLine);
     List<OrderLine> getByOrderId(GetOrderByOrderIdUseCase value);
     void delete(DeleteOrderLineUseCase deleteOrderLineUseCase);
}
