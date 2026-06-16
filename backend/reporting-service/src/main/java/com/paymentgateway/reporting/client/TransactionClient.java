package com.paymentgateway.reporting.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "TRANSACTION-SERVICE")
public interface TransactionClient {

    @GetMapping("/api/v1/transactions")
    List<Object> getAllTransactions();
}