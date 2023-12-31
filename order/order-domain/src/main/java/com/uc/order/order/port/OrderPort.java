package com.uc.order.order.port;

import com.uc.order.order.model.Order;
import com.uc.order.order.usecase.DeleteOrderUseCase;

import java.util.List;

public interface OrderPort {
    Order save(Order order);
    Order getByOrderId(Long id);
    void delete(DeleteOrderUseCase deleteOrderUseCase);

    List<Order> getAll();
}
