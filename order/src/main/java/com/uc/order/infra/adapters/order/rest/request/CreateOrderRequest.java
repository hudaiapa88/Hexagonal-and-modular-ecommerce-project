package com.uc.order.infra.adapters.order.rest.request;

import com.uc.common.usecase.UseCase;
import com.uc.order.domain.order.usecase.CreateOrderUseCase;
import com.uc.order.infra.adapters.orderLine.rest.request.CreateOrderLineRequest;
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
