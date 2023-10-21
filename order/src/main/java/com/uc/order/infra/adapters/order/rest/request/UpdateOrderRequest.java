package com.uc.order.infra.adapters.order.rest.request;

import com.uc.order.domain.order.model.Address;
import com.uc.order.domain.order.usecase.UpdateOrderUseCase;
import com.uc.order.domain.orderline.usecase.CreateOrderLineUseCase;
import com.uc.order.infra.adapters.orderLine.rest.request.UpdateOrderLineRequest;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

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
