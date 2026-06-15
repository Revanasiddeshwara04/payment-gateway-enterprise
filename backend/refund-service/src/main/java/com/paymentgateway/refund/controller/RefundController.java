package com.paymentgateway.refund.controller;

import com.paymentgateway.refund.dto.CreateRefundRequest;
import com.paymentgateway.refund.entity.Refund;
import com.paymentgateway.refund.service.RefundService;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/refunds")
public class RefundController {

    private final RefundService refundService;

    public RefundController(
            RefundService refundService) {

        this.refundService = refundService;
    }

    @PostMapping
    public String createRefund(
            @RequestBody CreateRefundRequest request) {

        return refundService.createRefund(request);
    }

    @GetMapping("/{id}")
    public Refund getRefundById(
            @PathVariable Long id) {

        return refundService.getRefundById(id);
    }

    @GetMapping
    public List<Refund> getAllRefunds() {

        return refundService.getAllRefunds();
    }

    @PutMapping("/{id}/process")
    public String processRefund(
            @PathVariable Long id) {

        return refundService.processRefund(id);
    }
}