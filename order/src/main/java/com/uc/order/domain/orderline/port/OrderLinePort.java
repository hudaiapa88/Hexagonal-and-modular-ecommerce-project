package com.uc.order.domain.orderline.port;

import com.uc.order.domain.order.usecase.GetByOrderIdUseCase;
import com.uc.order.domain.orderline.model.OrderLine;
import com.uc.order.domain.orderline.usecase.DeleteOrderLineUseCase;

import java.util.List;

public interface OrderLinePort {
     OrderLine save(OrderLine orderLine);
     List<OrderLine> getByOrderId(GetByOrderIdUseCase value);
     void delete(DeleteOrderLineUseCase deleteOrderLineUseCase);
}
