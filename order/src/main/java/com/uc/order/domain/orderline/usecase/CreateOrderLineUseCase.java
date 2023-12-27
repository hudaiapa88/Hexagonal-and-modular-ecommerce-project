package com.uc.order.domain.orderline.usecase;

import  com.uc.order.domain.common.usecase.UseCase;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class CreateOrderLineUseCase implements UseCase {
    private Long orderId;
    private Integer quantity;
    private Long productId;
    private BigDecimal totalPrice;
}
