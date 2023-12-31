package com.uc.order.adapters.order.rest.request;

import com.uc.order.order.model.Address;
import com.uc.order.order.usecase.UpdateOrderUseCase;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateOrderRequest {
    private Address address;
    public UpdateOrderUseCase toUseCase(Long id) {
        UpdateOrderUseCase updateOrderUseCase= new UpdateOrderUseCase();
        updateOrderUseCase.setId(id);
        return updateOrderUseCase;
    }
}
