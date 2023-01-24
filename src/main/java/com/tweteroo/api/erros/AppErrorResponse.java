package com.tweteroo.api.erros;

public class AppErrorResponse {
    private int status;
    private String message;

    public AppErrorResponse() {
    }

    public int getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

