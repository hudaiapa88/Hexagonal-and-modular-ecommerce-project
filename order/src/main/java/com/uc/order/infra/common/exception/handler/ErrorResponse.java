package com.uc.order.infra.common.exception.handler;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErrorResponse {
    private String field;
    private String ExceptionClass;
    private String message;
}
