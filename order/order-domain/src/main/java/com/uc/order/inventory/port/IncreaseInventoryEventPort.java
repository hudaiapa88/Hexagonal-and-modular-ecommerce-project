package com.uc.order.inventory.port;

import com.uc.order.common.event.EventPublisher;
import com.uc.order.inventory.event.DecreaseInventoryEvent;

public interface IncreaseInventoryEventPort extends EventPublisher<DecreaseInventoryEvent> {

    
}
