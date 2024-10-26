package com.demotest.wepprogramming.model.exceptions;

public class InvalidUserException extends RuntimeException {
    public InvalidUserException() {
        super("Invalid user");
    }
}
