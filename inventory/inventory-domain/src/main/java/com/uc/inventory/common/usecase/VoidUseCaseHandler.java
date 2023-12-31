package com.uc.inventory.common.usecase;

public interface VoidUseCaseHandler<I extends UseCase> {
    void handle(I value);
}
