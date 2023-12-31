package com.uc.order.order.usecase;

import com.uc.order.common.DomainComponent;
import com.uc.order.common.usecase.UseCaseHandler;;
import com.uc.order.order.model.Order;
import com.uc.order.order.port.OrderPort;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@DomainComponent
@RequiredArgsConstructor
public class UpdateOrderUseCaseHandler implements UseCaseHandler<Order,UpdateOrderUseCase> {
    private final OrderPort orderPort;
    @Override
    public Order handle(UpdateOrderUseCase value) {
        Order order=orderPort.getByOrderId(value.getId());
        order.setAddress(value.getAddress());
        return orderPort.save(order);
    }
}
