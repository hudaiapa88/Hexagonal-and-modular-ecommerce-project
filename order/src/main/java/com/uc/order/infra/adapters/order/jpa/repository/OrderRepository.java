package com.uc.order.infra.adapters.order.jpa.repository;

import com.uc.order.infra.adapters.order.jpa.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<OrderEntity,Long> {
}
