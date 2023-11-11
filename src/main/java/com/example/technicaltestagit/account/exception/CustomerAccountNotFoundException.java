package com.example.technicaltestagit.account.exception;

public class CustomerAccountNotFoundException extends RuntimeException{
    public CustomerAccountNotFoundException(String message) {
        super(message);
    }
}
