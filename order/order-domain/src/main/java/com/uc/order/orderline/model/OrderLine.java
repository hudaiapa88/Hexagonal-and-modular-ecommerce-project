package com.uc.order.orderline.model;

import com.uc.order.order.model.Order;
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
