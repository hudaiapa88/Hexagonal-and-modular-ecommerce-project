package com.uc.order.infra.adapters.orderLine.jpa.repository;

import com.uc.order.infra.adapters.orderLine.jpa.entity.OrderLineEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderLineRepository extends JpaRepository<OrderLineEntity,Long> {
    List<OrderLineEntity> findByOrder_Id(Long id);
}
