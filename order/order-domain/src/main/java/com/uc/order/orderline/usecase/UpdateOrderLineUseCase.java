package com.uc.order.orderline.usecase;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateOrderLineUseCase {
    private Long id;
    private Integer quantity;
    private Long productId;
}
