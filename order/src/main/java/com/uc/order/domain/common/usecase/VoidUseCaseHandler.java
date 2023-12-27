package com.uc.order.domain.common.usecase;

public interface VoidUseCaseHandler<I extends UseCase> {
    void handle(I value);
}
