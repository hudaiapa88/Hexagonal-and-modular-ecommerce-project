package com.uc.order.domain.orderline.usecase;

import  com.uc.order.domain.common.DomainComponent;
import  com.uc.order.domain.common.usecase.UseCaseHandler;;
import com.uc.order.domain.catalog.model.Product;
import com.uc.order.domain.catalog.port.ProductPort;
import com.uc.order.domain.inventory.event.DecreaseInventoryEvent;
import com.uc.order.domain.inventory.port.DecreaseInventoryEventPort;
import com.uc.order.domain.order.port.OrderPort;
import com.uc.order.domain.orderline.model.OrderLine;
import com.uc.order.domain.orderline.port.OrderLinePort;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;


@Slf4j
@DomainComponent
@RequiredArgsConstructor
public class CreateOrderLineUseCaseHandler implements UseCaseHandler<OrderLine,CreateOrderLineUseCase> {

   private final OrderLinePort orderLinePort;
   private final OrderPort orderPort;
   private final ProductPort productPort;
   private final DecreaseInventoryEventPort decreaseInventoryEventPort;
    @Override
    public OrderLine handle(CreateOrderLineUseCase value) {
        OrderLine orderLine= new OrderLine();
        orderLine.setOrder(orderPort.getByOrderId(value.getOrderId()));
        orderLine.setProductId(value.getProductId());
        orderLine.setQuantity(value.getQuantity());
        Product product=productPort.getByProductId(value.getProductId());
        orderLine.setTotalPrice(new BigDecimal(value.getQuantity()).multiply(product.getPrice()));
        orderLine=orderLinePort.save(orderLine);
        decreaseInventoryEventPort.publish(DecreaseInventoryEvent.from(orderLine));
        return orderLine;
    }
}
