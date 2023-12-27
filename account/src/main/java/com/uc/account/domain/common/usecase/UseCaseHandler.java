package com.uc.account.domain.common.usecase;

public interface UseCaseHandler<O,I extends UseCase> {
    O handle(I value);
}
