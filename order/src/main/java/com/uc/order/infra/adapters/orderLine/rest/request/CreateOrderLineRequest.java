package com.uc.order.infra.adapters.orderLine.rest.request;

import com.uc.order.domain.orderline.usecase.CreateOrderLineUseCase;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateOrderLineRequest {
    private Long productId;
    @NotEmpty(message = "Miktar boş geçilemez")
    private Integer quantity;

    public CreateOrderLineUseCase toUseCase() {
        CreateOrderLineUseCase createOrderLineUseCase= new CreateOrderLineUseCase();
        createOrderLineUseCase.setProductId(productId);
        createOrderLineUseCase.setQuantity(quantity);
        return createOrderLineUseCase;
    }
}
