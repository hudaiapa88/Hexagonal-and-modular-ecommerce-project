package com.uc.order.domain.order.usecase;

import  com.uc.order.domain.common.DomainComponent;
import com.uc.order.domain.common.usecase.VoidUseCaseHandler;
import com.uc.order.domain.order.port.OrderPort;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@DomainComponent
@RequiredArgsConstructor
public class DeleteOrderUseCaseHandler implements VoidUseCaseHandler<DeleteOrderUseCase> {

    private final OrderPort orderPort;
    @Override
    public void handle(DeleteOrderUseCase value) {
        orderPort.delete(value);
    }
}
