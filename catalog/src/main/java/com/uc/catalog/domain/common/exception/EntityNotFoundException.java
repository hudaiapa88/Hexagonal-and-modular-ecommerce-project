package com.uc.catalog.domain.common.exception;


import com.uc.catalog.domain.common.exception.base.BaseException;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class EntityNotFoundException extends BaseException {

    public EntityNotFoundException(String message) {
        super(message);
    }


}
