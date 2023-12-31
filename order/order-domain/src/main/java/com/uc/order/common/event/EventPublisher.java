package com.uc.order.common.event;

public interface EventPublisher <T extends Event>{
    void publish(T event);
}
