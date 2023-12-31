package com.uc.order.order.usecase;

import com.uc.order.common.DomainComponent;
import com.uc.order.common.usecase.UseCaseHandler;;
import com.uc.order.order.model.Order;
import com.uc.order.order.port.OrderPort;
import com.uc.order.orderline.model.OrderLine;
import com.uc.order.orderline.usecase.CreateOrderLineUseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@DomainComponent
@RequiredArgsConstructor
public class CreateOrderUseCaseHandler implements UseCaseHandler<Order, CreateOrderUseCase> {

    private final OrderPort orderPort;

    private final UseCaseHandler<OrderLine, CreateOrderLineUseCase> createOrderLineUseCaseHandler;

    @Override
    public Order handle(CreateOrderUseCase value) {
        Order order = new Order();
        order.setTotalPrice(new BigDecimal(0));
        order = orderPort.save(order);
        List<OrderLine> orderLines = createOrderLines(value.getOrderLines(), order);
       // order.setOrderLines(orderLines);
        order.setTotalPrice(calculateTotalPrice(orderLines));
        return orderPort.save(order);
    }

    private List<OrderLine> createOrderLines(List<CreateOrderLineUseCase> orderLines, Order order) {
        return orderLines.stream().map(createOrderLineUseCase -> {
            createOrderLineUseCase.setOrderId(order.getId());
            return createOrderLineUseCaseHandler.handle(createOrderLineUseCase);
        }).collect(Collectors.toList());
    }

    private BigDecimal calculateTotalPrice(List<OrderLine> orderLines) {
        return orderLines.stream().reduce(new BigDecimal(0), (total, orderLine) -> total.add(orderLine.getTotalPrice()), BigDecimal::add);
    }
}
