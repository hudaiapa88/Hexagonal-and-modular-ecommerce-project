package com.uc.order.domain.orderline.model;

import com.uc.order.domain.order.model.Order;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;

@Getter
@Setter
public class OrderLine {
    private Long id;
    private Integer quantity;
    private Long productId;
    private BigDecimal totalPrice;
    private Order order;
}
