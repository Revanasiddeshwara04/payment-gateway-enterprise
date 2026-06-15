package com.paymentgateway.settlement.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(
            SettlementNotFoundException.class)
    public ResponseEntity<String> handleException(
            SettlementNotFoundException ex) {

        return ResponseEntity
                .badRequest()
                .body(ex.getMessage());
    }
}