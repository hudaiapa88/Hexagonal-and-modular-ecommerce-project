package com.uc.order.domain.order.usecase;

import  com.uc.order.domain.common.usecase.UseCase;
import com.uc.order.domain.order.model.Address;
import com.uc.order.domain.orderline.usecase.CreateOrderLineUseCase;
import jakarta.validation.Valid;
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
