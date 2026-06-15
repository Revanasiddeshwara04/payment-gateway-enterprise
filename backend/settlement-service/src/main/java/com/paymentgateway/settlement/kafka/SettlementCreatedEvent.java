package com.paymentgateway.settlement.kafka;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class SettlementCreatedEvent {

    private String settlementId;
    private String status;
}