package com.uc.order.infra.adapters.orderLine.rest.request;

import com.uc.order.domain.orderline.usecase.UpdateOrderLineUseCase;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateOrderLineRequest {
    public UpdateOrderLineUseCase toUseCase() {
    }
}
