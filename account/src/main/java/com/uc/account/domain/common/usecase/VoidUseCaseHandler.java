package com.uc.account.domain.common.usecase;

public interface VoidUseCaseHandler<I extends UseCase> {
    void handle(I value);
}
