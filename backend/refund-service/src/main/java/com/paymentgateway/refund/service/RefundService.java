package com.paymentgateway.refund.service;

import com.paymentgateway.refund.dto.CreateRefundRequest;
import com.paymentgateway.refund.entity.Refund;
import com.paymentgateway.refund.repository.RefundRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class RefundService {

    private final RefundRepository refundRepository;

    public RefundService(
            RefundRepository refundRepository) {

        this.refundRepository = refundRepository;
    }

    public String createRefund(
            CreateRefundRequest request) {

        Refund refund = new Refund();

        refund.setRefundId(
                UUID.randomUUID().toString());

        refund.setPaymentId(
                request.getPaymentId());

        refund.setTransactionId(
                request.getTransactionId());

        refund.setAmount(
                request.getAmount());

        refund.setReason(
                request.getReason());

        refund.setStatus("REFUND_INITIATED");

        refundRepository.save(refund);

        return "Refund Created Successfully";
    }

    public Refund getRefundById(Long id) {

        return refundRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException(
                                "Refund not found"));
    }

    public List<Refund> getAllRefunds() {

        return refundRepository.findAll();
    }

    public String processRefund(Long id) {

        Refund refund =
                refundRepository.findById(id)
                        .orElseThrow(() ->
                                new RuntimeException(
                                        "Refund not found"));

        refund.setStatus("REFUNDED");

        refundRepository.save(refund);

        return "Refund Processed Successfully";
    }
}