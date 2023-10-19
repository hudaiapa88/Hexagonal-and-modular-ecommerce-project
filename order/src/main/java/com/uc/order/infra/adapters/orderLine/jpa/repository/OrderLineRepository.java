package com.uc.order.infra.adapters.orderLine.jpa.repository;

import com.uc.order.infra.adapters.orderLine.jpa.entity.OrderLineEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderLineRepository extends JpaRepository<OrderLineEntity,Long> {
}
