package com.uc.common.usecase;

public interface VoidUseCaseHandler<I extends UseCase> {
    void handle(I value);
}
