package com.uc.order.order.usecase;

import com.uc.order.common.DomainComponent;
import com.uc.order.common.usecase.UseCaseHandler;;
import com.uc.order.order.model.Order;
import com.uc.order.order.port.OrderPort;
import lombok.RequiredArgsConstructor;

@DomainComponent
@RequiredArgsConstructor
public class GetOrderByOrderIdUseCaseHandler implements UseCaseHandler<Order, GetOrderByOrderIdUseCase> {
    private final OrderPort orderPort;
    @Override
    public Order handle(GetOrderByOrderIdUseCase value) {
        return orderPort.getByOrderId(value.getId());
    }
}
