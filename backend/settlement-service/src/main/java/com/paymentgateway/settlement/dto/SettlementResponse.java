package com.paymentgateway.settlement.dto;

import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
@Builder
public class SettlementResponse {

    private Long id;
    private String settlementId;
    private Long merchantId;
    private Long transactionId;
    private BigDecimal amount;
    private String status;
}