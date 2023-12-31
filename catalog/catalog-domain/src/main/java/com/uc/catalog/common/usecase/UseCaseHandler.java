package com.uc.catalog.common.usecase;

public interface UseCaseHandler<O,I extends UseCase> {
    O handle(I value);
}
