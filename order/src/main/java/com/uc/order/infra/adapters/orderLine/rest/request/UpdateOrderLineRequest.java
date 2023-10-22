package com.uc.order.infra.adapters.orderLine.rest.request;

import com.uc.order.domain.orderline.usecase.UpdateOrderLineUseCase;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class UpdateOrderLineRequest {
    private Integer quantity;
    private Long productId;
    public UpdateOrderLineUseCase toUseCase(Long id) {
        UpdateOrderLineUseCase updateOrderLineUseCase= new UpdateOrderLineUseCase();
        updateOrderLineUseCase.setId(id);
        updateOrderLineUseCase.setProductId(productId);
        updateOrderLineUseCase.setQuantity(quantity);
        return updateOrderLineUseCase;
    }
}
