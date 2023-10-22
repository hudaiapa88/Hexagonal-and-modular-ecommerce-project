package com.uc.order.domain.order.usecase;

import com.uc.common.usecase.UseCase;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class GetByOrderIdUseCase implements UseCase {
    private Long id;
}
