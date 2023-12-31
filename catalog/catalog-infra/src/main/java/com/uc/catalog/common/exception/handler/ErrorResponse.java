package com.uc.catalog.common.exception.handler;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErrorResponse {
    private String field;
    private String ExceptionClass;
    private String message;
}
