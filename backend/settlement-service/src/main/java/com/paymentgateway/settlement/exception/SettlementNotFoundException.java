package com.paymentgateway.settlement.exception;

public class SettlementNotFoundException
        extends RuntimeException {

    public SettlementNotFoundException(
            String message) {

        super(message);
    }
}