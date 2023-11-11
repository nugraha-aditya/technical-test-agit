package com.example.technicaltestagit.account.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class CustomerAccountExceptionHandler {
    @ExceptionHandler({CustomerAccountNotFoundException.class})
    @ResponseBody
    public ResponseEntity<Object> handleStudentNotFoundException(CustomerAccountNotFoundException exception) {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(exception.getMessage());
    }

    @ExceptionHandler({TransferBalanceInsufficientException.class})
    @ResponseBody
    public ResponseEntity<Object> handleTransferBalanceInsufficient(TransferBalanceInsufficientException exception) {
        return ResponseEntity
                .status(HttpStatus.UNPROCESSABLE_ENTITY)
                .body(exception.getMessage());
    }
}
