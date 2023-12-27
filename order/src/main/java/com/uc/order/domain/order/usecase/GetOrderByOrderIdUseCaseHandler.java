package com.uc.order.domain.order.usecase;

import  com.uc.order.domain.common.DomainComponent;
import  com.uc.order.domain.common.usecase.UseCaseHandler;;
import com.uc.order.domain.order.model.Order;
import com.uc.order.domain.order.port.OrderPort;
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
