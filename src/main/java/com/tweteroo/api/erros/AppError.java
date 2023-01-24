package com.tweteroo.api.erros;

public class AppError extends Exception{
    private final String message;
    private final Integer code;

    public AppError(String message, Integer code) {
        this.message = message;
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public Integer getCode() {
        return code;
    }
}
