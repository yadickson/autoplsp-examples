package com.autoplsp.rest.exception;

import lombok.Getter;

public final class BusinessException extends Exception {
    
    @Getter
    private final Long code;
    
    public BusinessException(final Long code, final String message, final Throwable cause) {
        super(message, cause);
        this.code = code;
    }
}
