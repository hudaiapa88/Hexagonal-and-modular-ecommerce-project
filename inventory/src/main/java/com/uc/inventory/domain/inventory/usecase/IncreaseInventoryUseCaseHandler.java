package com.uc.inventory.domain.inventory.usecase;

import com.uc.common.DomainComponent;
import com.uc.common.usecase.VoidUseCaseHandler;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@DomainComponent
@RequiredArgsConstructor
public class IncreaseInventoryUseCaseHandler implements VoidUseCaseHandler<IncreaseInventoryUseCase> {
    @Override
    public void handle(IncreaseInventoryUseCase value) {

    }
}
