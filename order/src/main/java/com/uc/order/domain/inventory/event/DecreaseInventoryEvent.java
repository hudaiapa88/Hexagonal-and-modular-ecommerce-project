package com.uc.order.domain.inventory.event;

import com.uc.common.event.Event;
import com.uc.order.domain.orderline.model.OrderLine;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class DecreaseInventoryEvent implements Event {

    private Long productId;
    private Long amount;

    public static DecreaseInventoryEvent from(OrderLine orderLine) {
        DecreaseInventoryEvent decreaseInventoryEvent= new DecreaseInventoryEvent();
        decreaseInventoryEvent.setProductId(orderLine.getProductId());
        decreaseInventoryEvent.setAmount(orderLine.getQuantity().longValue());
        return decreaseInventoryEvent;
    }
}
