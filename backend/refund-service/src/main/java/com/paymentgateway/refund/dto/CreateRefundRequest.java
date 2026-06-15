package com.paymentgateway.refund.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class CreateRefundRequest {

    private Long paymentId;

    private Long transactionId;

    private BigDecimal amount;

    private String reason;
}