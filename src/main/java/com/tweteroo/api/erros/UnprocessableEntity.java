package com.tweteroo.api.erros;

public class UnprocessableEntity extends AppError{
    public UnprocessableEntity(String message) {
        super(message, 422);
    }
}
