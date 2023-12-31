package com.uc.order.adapters.orderLine.rest.request;

import com.uc.order.orderline.usecase.UpdateOrderLineUseCase;
import lombok.Getter;
import lombok.Setter;

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
