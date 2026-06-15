package com.paymentgateway.settlement.controller;

import com.paymentgateway.settlement.dto.CreateSettlementRequest;
import com.paymentgateway.settlement.entity.Settlement;
import com.paymentgateway.settlement.service.SettlementService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/settlements")
public class SettlementController {

    private final SettlementService
            settlementService;

    public SettlementController(
            SettlementService settlementService) {

        this.settlementService = settlementService;
    }

    @PostMapping
    public String createSettlement(
            @RequestBody
            CreateSettlementRequest request) {

        return settlementService
                .createSettlement(request);
    }

    @GetMapping("/{id}")
    public Settlement getSettlementById(
            @PathVariable Long id) {

        return settlementService
                .getSettlementById(id);
    }

    @GetMapping
    public List<Settlement>
    getAllSettlements() {

        return settlementService.getAllSettlements();
    }

    @GetMapping("/merchant/{merchantId}")
    public List<Settlement>
    getMerchantSettlements(
            @PathVariable Long merchantId) {

        return settlementService.getMerchantSettlements(
                        merchantId);
    }

    @PutMapping("/{id}/process")
    public String processSettlement(
            @PathVariable Long id) {

        return settlementService.processSettlement(id);
    }
}