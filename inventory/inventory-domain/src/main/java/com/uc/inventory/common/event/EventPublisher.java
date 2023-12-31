package com.uc.inventory.common.event;

public interface EventPublisher <T extends Event>{
    void publish(T event);
}
