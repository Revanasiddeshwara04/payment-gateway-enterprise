package com.paymentgateway.payment.controller;

import com.paymentgateway.payment.dto.CreatePaymentRequest;
import com.paymentgateway.payment.entity.Payment;
import com.paymentgateway.payment.service.PaymentService;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/payments")
public class PaymentController {

    private final PaymentService paymentService;

    public PaymentController(
            PaymentService paymentService) {

        this.paymentService = paymentService;
    }

    @PostMapping
    public String createPayment(
            @RequestBody CreatePaymentRequest request) {

        return paymentService.createPayment(
                request);
    }

    @GetMapping("/{id}")
    public Payment getPaymentById(
            @PathVariable Long id) {

        return paymentService.getPaymentById(id);
    }

    @GetMapping
    public List<Payment> getAllPayments() {

        return paymentService.getAllPayments();
    }

    @PutMapping("/{id}/cancel")
    public String cancelPayment(
            @PathVariable Long id) {

        return paymentService.cancelPayment(id);
    }
}