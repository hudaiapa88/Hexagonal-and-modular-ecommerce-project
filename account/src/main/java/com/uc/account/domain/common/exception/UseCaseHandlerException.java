package com.uc.account.domain.common.exception;


import com.uc.account.domain.common.exception.base.BaseException;

public class UseCaseHandlerException extends BaseException {
    public UseCaseHandlerException(String message) {
        super(message);
    }
}
