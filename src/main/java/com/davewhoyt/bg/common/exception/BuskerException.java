package com.davewhoyt.bg.common.exception;

import com.davewhoyt.bg.common.ErrorType;

/**
 * Encapsulates SnaFoo-specific error messaging in a custom type.
 *
 * Some things would be easier to test if I subclassed this and gave each subclass
 * its own ErrorType.
 */
public class BuskerException extends RuntimeException {
    public final ErrorType errorType;
    public BuskerException() {
        this.errorType = ErrorType.UNKNOWN;
    }
    public BuskerException(ErrorType errorType) {
        this.errorType = errorType;
    }
    public BuskerException(ErrorType errorType, Exception e) {
        super(e);
        this.errorType = errorType;
    }
    public BuskerException(ErrorType errorType, String message, Exception e) {
        super(message, e);
        this.errorType = errorType;
    }
}
