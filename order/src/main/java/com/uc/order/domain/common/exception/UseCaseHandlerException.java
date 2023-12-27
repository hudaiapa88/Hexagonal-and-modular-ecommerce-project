package com.uc.order.domain.common.exception;

import com.uc.order.domain.common.exception.base.BaseException;

public class UseCaseHandlerException extends BaseException {
    public UseCaseHandlerException(String message) {
        super(message);
    }
}
