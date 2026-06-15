package com.paymentgateway.payment.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class CreatePaymentRequest {

    private Long merchantId;

    private BigDecimal amount;

    private String currency;

    private String paymentMethod;
}