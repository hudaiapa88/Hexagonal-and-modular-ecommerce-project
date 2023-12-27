package com.uc.order.domain.order.usecase;

import  com.uc.order.domain.common.DomainComponent;
import com.uc.order.domain.common.usecase.NoUseCaseHandler;
import com.uc.order.domain.order.model.Order;
import com.uc.order.domain.order.port.OrderPort;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
@DomainComponent
@RequiredArgsConstructor
public class GetAllOrderUseCaseHandler implements NoUseCaseHandler<List<Order>> {

  private final OrderPort orderPort;

    @Override
    public List<Order> handle() {
        return orderPort.getAll();
    }
}
