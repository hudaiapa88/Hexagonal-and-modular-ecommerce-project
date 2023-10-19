package com.uc.order.infra.adapters.orderLine.jpa.entity;

import com.uc.order.infra.adapters.order.jpa.entity.OrderEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "orderline")
@Getter
@Setter
public class OrderLineEntity {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "generator_sequence"
    )
    @SequenceGenerator(
            name = "generator_sequence",
            allocationSize = 1
    )
    private Long id;
    private Integer quantity;
    private Long productId;
    private BigDecimal totalPrice;
    @ManyToOne
    private OrderEntity order;
}
