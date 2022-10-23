package com.uc.common.usecase;

public interface UserCaseHandler<O,I extends UseCase> {
    O handle(I value);
}
