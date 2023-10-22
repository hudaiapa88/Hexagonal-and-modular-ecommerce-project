package com.uc.order.domain.order.usecase;

import com.uc.common.DomainComponent;
import com.uc.common.usecase.UseCaseHandler;
import com.uc.order.domain.order.model.Order;
import com.uc.order.domain.order.port.OrderPort;
import lombok.RequiredArgsConstructor;

@DomainComponent
@RequiredArgsConstructor
public class GetByOrderIdUseCaseHandler implements UseCaseHandler<Order,GetByOrderIdUseCase> {
    private final OrderPort orderPort;
    @Override
    public Order handle(GetByOrderIdUseCase value) {
        return orderPort.getByOrderId(value.getId());
    }
}
