package com.paymentgateway.settlement.service;

import com.paymentgateway.settlement.dto.CreateSettlementRequest;
import com.paymentgateway.settlement.entity.Settlement;
import com.paymentgateway.settlement.enums.SettlementStatus;
import com.paymentgateway.settlement.repository.SettlementRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class SettlementService {

    private final SettlementRepository settlementRepository;

    public SettlementService(
            SettlementRepository settlementRepository) {

        this.settlementRepository = settlementRepository;
    }

    public String createSettlement(
            CreateSettlementRequest request) {

        Settlement settlement = new Settlement();

        settlement.setSettlementId(
                UUID.randomUUID().toString());

        settlement.setMerchantId(
                request.getMerchantId());

        settlement.setTransactionId(
                request.getTransactionId());

        settlement.setAmount(
                request.getAmount());

        settlement.setStatus(
                SettlementStatus.PENDING);

        settlementRepository.save(settlement);

        return "Settlement Created Successfully";
    }

    public Settlement getSettlementById(
            Long id) {

        return settlementRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException(
                                "Settlement not found"));
    }

    public List<Settlement> getAllSettlements() {

        return settlementRepository.findAll();
    }

    public List<Settlement> getMerchantSettlements(
            Long merchantId) {

        return settlementRepository.findByMerchantId(
                merchantId);
    }

    public String processSettlement(
            Long id) {

        Settlement settlement =
                settlementRepository.findById(id)
                        .orElseThrow(() ->
                                new RuntimeException(
                                        "Settlement not found"));

        settlement.setStatus(
                SettlementStatus.SETTLED);

        settlementRepository.save(settlement);

        return "Settlement Processed Successfully";
    }
}