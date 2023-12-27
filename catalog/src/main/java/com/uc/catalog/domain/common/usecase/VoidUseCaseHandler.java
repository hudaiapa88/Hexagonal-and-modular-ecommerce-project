package com.uc.catalog.domain.common.usecase;

public interface VoidUseCaseHandler<I extends UseCase> {
    void handle(I value);
}
