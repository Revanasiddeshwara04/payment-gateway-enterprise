package com.paymentgateway.settlement.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class CreateSettlementRequest {

    private Long merchantId;

    private Long transactionId;

    private BigDecimal amount;
}