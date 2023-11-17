package com.uc.order.domain.inventory.port;

import com.uc.common.event.EventPublisher;
import com.uc.order.domain.inventory.event.DecreaseInventoryEvent;
import com.uc.order.domain.inventory.event.IncreaseInventoryEvent;

public interface IncreaseInventoryEventPort extends EventPublisher<DecreaseInventoryEvent> {

    
}
