package com.uc.order.domain.order.port;

import com.uc.order.domain.order.model.Order;
import com.uc.order.domain.order.usecase.DeleteOrderUseCase;
import com.uc.order.domain.orderline.model.OrderLine;
import com.uc.order.domain.orderline.usecase.DeleteOrderLineUseCase;

import java.util.List;

public interface OrderPort {
    Order save(Order order);
    Order getByOrderId(Long id);
    void delete(DeleteOrderUseCase deleteOrderUseCase);

    List<Order> getAll();
}
