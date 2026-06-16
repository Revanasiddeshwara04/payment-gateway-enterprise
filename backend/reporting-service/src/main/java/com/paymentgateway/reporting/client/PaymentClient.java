package com.paymentgateway.reporting.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "PAYMENT-SERVICE")
public interface PaymentClient {

    @GetMapping("/api/v1/payments")
    List<Object> getAllPayments();
}