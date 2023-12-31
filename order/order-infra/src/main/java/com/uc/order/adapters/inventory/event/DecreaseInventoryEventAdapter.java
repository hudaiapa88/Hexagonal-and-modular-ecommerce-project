package com.uc.adapters.inventory.event;

import com.uc.order.inventory.event.DecreaseInventoryEvent;
import com.uc.order.inventory.port.DecreaseInventoryEventPort;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
@Slf4j
@Service
@RequiredArgsConstructor
public class DecreaseInventoryEventAdapter implements DecreaseInventoryEventPort {

    @Value("${kafka.order.producer.decreaseInventory.topic}")
    private String topic;

    @Qualifier("decreaseInventoryProducer")
    private final KafkaTemplate<String, Object> kafka;
    @Override
    public void publish(DecreaseInventoryEvent event) {
       log.info(event.toString());
       kafka.send(topic,event);
    }
}
