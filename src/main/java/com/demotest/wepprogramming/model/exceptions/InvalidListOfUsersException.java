package com.demotest.wepprogramming.model.exceptions;

public class InvalidListOfUsersException extends RuntimeException{
    public InvalidListOfUsersException(){
        super("Invalid list of users");
    }
}
