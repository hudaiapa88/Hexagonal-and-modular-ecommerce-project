package com.uc.order.orderline.usecase;

import com.uc.order.common.usecase.UseCase;
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
