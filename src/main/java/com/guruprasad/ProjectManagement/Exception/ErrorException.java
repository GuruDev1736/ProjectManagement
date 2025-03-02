package com.guruprasad.ProjectManagement.Exception;

public class ErrorException extends RuntimeException{

    public ErrorException(String message) {
        super(message);
    }

    public ErrorException() {
        super();
    }
}
