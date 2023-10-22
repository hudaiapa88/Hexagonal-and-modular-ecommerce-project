package com.uc.order.domain.order.model;

import com.uc.order.domain.orderline.model.OrderLine;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Order {
    private Long id;
    private LocalDateTime createdDateTime;
    private LocalDateTime updatedDateTime;
    private List<OrderLine> orderLines= new ArrayList<>();
    private Address address;
    private BigDecimal totalPrice;
}
