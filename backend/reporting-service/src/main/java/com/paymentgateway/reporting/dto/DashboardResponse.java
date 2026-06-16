package com.paymentgateway.reporting.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class DashboardResponse {

    private Long totalPayments;

    private Long totalTransactions;

    private Long totalRefunds;

    private Long totalSettlements;
}