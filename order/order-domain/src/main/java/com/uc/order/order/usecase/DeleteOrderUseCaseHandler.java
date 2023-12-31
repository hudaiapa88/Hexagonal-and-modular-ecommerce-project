package com.uc.order.order.usecase;

import com.uc.order.common.DomainComponent;
import com.uc.order.common.usecase.VoidUseCaseHandler;
import com.uc.order.order.port.OrderPort;
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
