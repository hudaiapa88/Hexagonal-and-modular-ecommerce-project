package com.uc.order.adapters.orderLine.rest.request;

import com.uc.order.orderline.usecase.CreateOrderLineUseCase;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateOrderLineRequest {
    private Long productId;
    private Integer quantity;

    public CreateOrderLineUseCase toUseCase() {
        CreateOrderLineUseCase createOrderLineUseCase= new CreateOrderLineUseCase();
        createOrderLineUseCase.setProductId(productId);
        createOrderLineUseCase.setQuantity(quantity);
        return createOrderLineUseCase;
    }
}
