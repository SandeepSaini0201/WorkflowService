package com.crptm.ws.exception;

import lombok.Getter;

@Getter
public class BaseException extends RuntimeException {

    private int code;

    public BaseException(String message) {
        super(message);
    }

    public BaseException(String message, int code) {
        super(message);
        this.code = code;
    }

    public BaseException(String message, Throwable cause) {
        super(message, cause);
    }
}
