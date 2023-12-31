package com.uc.inventory.common.usecase;

public interface UseCaseHandler<O,I extends UseCase> {
    O handle(I value);
}
