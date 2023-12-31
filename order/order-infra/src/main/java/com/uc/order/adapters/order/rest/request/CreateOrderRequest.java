package com.uc.order.adapters.order.rest.request;


import com.uc.order.adapters.orderLine.rest.request.CreateOrderLineRequest;
import com.uc.order.common.usecase.UseCase;
import com.uc.order.order.usecase.CreateOrderUseCase;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
public class CreateOrderRequest implements UseCase {
    private List<CreateOrderLineRequest> orderLines = new ArrayList<>();
    @Valid
    private AddressRequest addressRequest;

    public CreateOrderUseCase toUseCase() {
        CreateOrderUseCase createOrderUseCase= new CreateOrderUseCase();
        createOrderUseCase.setOrderLines(orderLines.stream().map(CreateOrderLineRequest::toUseCase).collect(Collectors.toList()));
        createOrderUseCase.setAddress(addressRequest.toAddress());
        return createOrderUseCase;
    }
}
