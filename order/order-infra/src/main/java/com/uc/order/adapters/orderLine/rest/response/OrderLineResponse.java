package com.uc.order.adapters.orderLine.rest.response;


import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class OrderLineResponse {
    private Long productId;
    private Integer quantity;
    private BigDecimal totalPrice;
}
