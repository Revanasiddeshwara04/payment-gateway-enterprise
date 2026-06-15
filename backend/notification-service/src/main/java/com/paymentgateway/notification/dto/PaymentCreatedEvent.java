package com.paymentgateway.notification.dto;

public class PaymentCreatedEvent {

    private String paymentId;
    private String status;

    public PaymentCreatedEvent() {
    }

    public String getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}