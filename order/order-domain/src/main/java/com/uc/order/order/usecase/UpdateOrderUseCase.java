package com.uc.order.order.usecase;

import com.uc.order.common.usecase.UseCase;
import com.uc.order.order.model.Address;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateOrderUseCase implements UseCase {
    private Long id;
    private Address address;
}
