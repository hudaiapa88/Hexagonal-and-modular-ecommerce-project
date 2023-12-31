package com.uc.order.adapters.order.jpa.repository;


import com.uc.order.adapters.order.jpa.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<OrderEntity,Long> {
}
