package com.uc.order.common.exception;


import com.uc.order.common.exception.base.BaseException;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class EntityNotFoundException extends BaseException {

    public EntityNotFoundException(String message) {
        super(message);
    }


}
