package com.uc.order.order.usecase;

import com.uc.order.common.usecase.UseCase;
import com.uc.order.order.model.Address;
import com.uc.order.orderline.usecase.CreateOrderLineUseCase;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class CreateOrderUseCase implements UseCase {
    private List<CreateOrderLineUseCase> orderLines= new ArrayList<>();
    private Address address;
}
