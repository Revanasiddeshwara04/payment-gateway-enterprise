package com.paymentgateway.reporting.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "SETTLEMENT-SERVICE")
public interface SettlementClient {

    @GetMapping("/api/v1/settlements")
    List<Object> getAllSettlements();
}