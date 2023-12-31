package com.uc.inventory.adapters.inventory.event.deserializer;



import com.uc.inventory.inventory.event.DecreaseInventoryEvent;
import org.springframework.kafka.support.serializer.JsonDeserializer;

public class DecreaseInventoryEventDeserializer extends JsonDeserializer<DecreaseInventoryEvent> {
}
