package com.tweteroo.api.erros;

public class NotFoundError extends AppError{
    public NotFoundError(String message) {
        super(message, 404);
    }
}
