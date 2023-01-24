package com.tweteroo.api.controllers;

import com.tweteroo.api.erros.AppErrorResponse;
import com.tweteroo.api.erros.NotFoundError;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NotFoundError.class)
    @ResponseBody
    public AppErrorResponse handleNotFoundError(NotFoundError e) {
        AppErrorResponse error = new AppErrorResponse();
        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setMessage(e.getMessage());
        return error;
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public void handleAllOtherExceptions(Exception e) {
        System.out.println("Exception: " + e.getMessage());
    }
}




