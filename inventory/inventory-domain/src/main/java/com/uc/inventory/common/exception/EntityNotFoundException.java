package com.uc.inventory.common.exception;


import com.uc.inventory.common.exception.base.BaseException;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class EntityNotFoundException extends BaseException {

    public EntityNotFoundException(String message) {
        super(message);
    }


}
