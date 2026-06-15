package com.paymentgateway.transaction.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class CreateTransactionRequest {

    private Long paymentId;

    private Long merchantId;

    private BigDecimal amount;

    private String currency;
}