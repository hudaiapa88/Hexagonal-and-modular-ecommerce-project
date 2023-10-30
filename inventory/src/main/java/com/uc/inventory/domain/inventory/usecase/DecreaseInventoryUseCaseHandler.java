package com.uc.inventory.domain.inventory.usecase;

import com.uc.common.DomainComponent;
import com.uc.common.usecase.UseCaseHandler;
import com.uc.common.usecase.VoidUseCaseHandler;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@DomainComponent
@RequiredArgsConstructor
public class DecreaseInventoryUseCaseHandler implements VoidUseCaseHandler<DecreaseInventoryUseCase> {
    @Override
    public void handle(DecreaseInventoryUseCase value) {

    }
}
