package com.paymentgateway.reporting.service;

import com.paymentgateway.reporting.client.PaymentClient;
import com.paymentgateway.reporting.client.RefundClient;
import com.paymentgateway.reporting.client.SettlementClient;
import com.paymentgateway.reporting.client.TransactionClient;
import com.paymentgateway.reporting.dto.DashboardResponse;
import org.springframework.stereotype.Service;

@Service
public class ReportService {

    private final PaymentClient paymentClient;
    private final TransactionClient transactionClient;
    private final RefundClient refundClient;
    private final SettlementClient settlementClient;

    public ReportService(
            PaymentClient paymentClient,
            TransactionClient transactionClient,
            RefundClient refundClient,
            SettlementClient settlementClient) {

        this.paymentClient = paymentClient;
        this.transactionClient = transactionClient;
        this.refundClient = refundClient;
        this.settlementClient = settlementClient;
    }

    public DashboardResponse getDashboard() {

        return DashboardResponse.builder()
                .totalPayments(
                        (long) paymentClient
                                .getAllPayments()
                                .size())

                .totalTransactions(
                        (long) transactionClient
                                .getAllTransactions()
                                .size())

                .totalRefunds(
                        (long) refundClient
                                .getAllRefunds()
                                .size())

                .totalSettlements(
                        (long) settlementClient
                                .getAllSettlements()
                                .size())

                .build();
    }
}