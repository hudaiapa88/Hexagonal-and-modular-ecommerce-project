package com.uc.order.domain.inventory.port;

import com.uc.common.event.EventPublisher;
import com.uc.order.domain.inventory.event.DecreaseInventoryEvent;

public interface DecreaseInventoryEventPort extends EventPublisher<DecreaseInventoryEvent> {
}
