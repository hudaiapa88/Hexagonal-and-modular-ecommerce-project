package com.uc.order.domain.inventory.port;

import com.uc.order.domain.common.event.EventPublisher;
import com.uc.order.domain.inventory.event.DecreaseInventoryEvent;

public interface IncreaseInventoryEventPort extends EventPublisher<DecreaseInventoryEvent> {

    
}
