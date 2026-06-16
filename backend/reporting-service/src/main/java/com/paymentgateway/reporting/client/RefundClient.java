package com.paymentgateway.reporting.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "REFUND-SERVICE")
public interface RefundClient {

    @GetMapping("/api/v1/refunds")
    List<Object> getAllRefunds();
}