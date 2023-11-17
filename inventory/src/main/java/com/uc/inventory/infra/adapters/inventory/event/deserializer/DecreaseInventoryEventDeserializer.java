package com.uc.inventory.infra.adapters.inventory.event.deserializer;

import com.uc.inventory.domain.inventory.event.DecreaseInventoryEvent;
import org.springframework.kafka.support.serializer.JsonDeserializer;


public class DecreaseInventoryEventDeserializer extends JsonDeserializer<DecreaseInventoryEvent> {
}
