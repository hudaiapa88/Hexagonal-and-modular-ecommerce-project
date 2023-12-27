package com.uc.order.domain.order.usecase;

import  com.uc.order.domain.common.usecase.UseCase;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class GetOrderByOrderIdUseCase implements UseCase {
    private Long id;
}
