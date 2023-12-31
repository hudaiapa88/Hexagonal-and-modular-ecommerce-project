package com.uc.order.common.usecase;

public interface VoidUseCaseHandler<I extends UseCase> {
    void handle(I value);
}
