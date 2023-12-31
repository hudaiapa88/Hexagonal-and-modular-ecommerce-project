package com.uc.order.order.model;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
public class Order {
    private Long id;
    private LocalDateTime createdDateTime;
    private LocalDateTime updatedDateTime;
    private Address address;
    private BigDecimal totalPrice;
}
