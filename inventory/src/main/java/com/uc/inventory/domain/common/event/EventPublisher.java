package com.uc.inventory.domain.common.event;

public interface EventPublisher <T extends Event>{
    void publish(T event);
}
