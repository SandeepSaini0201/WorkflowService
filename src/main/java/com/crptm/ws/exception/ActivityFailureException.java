package com.crptm.ws.exception;

public class ActivityFailureException extends BaseException {

    public ActivityFailureException(String message) {
        super(message);
    }

    public ActivityFailureException(String message, int code) {
        super(message, code);
    }

    public ActivityFailureException(String message, Throwable cause) {
        super(message, cause);
    }
}
