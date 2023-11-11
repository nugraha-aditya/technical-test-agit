package com.example.technicaltestagit.account.exception;

public class TransferBalanceInsufficientException extends RuntimeException {
    public TransferBalanceInsufficientException(String message) {
        super(message);
    }
}
