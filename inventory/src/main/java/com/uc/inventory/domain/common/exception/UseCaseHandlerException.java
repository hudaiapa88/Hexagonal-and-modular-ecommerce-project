package com.uc.inventory.domain.common.exception;

import com.uc.inventory.domain.common.exception.base.BaseException;

public class UseCaseHandlerException extends BaseException {
    public UseCaseHandlerException(String message) {
        super(message);
    }
}
