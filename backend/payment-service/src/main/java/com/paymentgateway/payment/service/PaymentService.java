package com.paymentgateway.payment.service;

import com.paymentgateway.payment.dto.CreatePaymentRequest;
import com.paymentgateway.payment.entity.Payment;
import com.paymentgateway.payment.kafka.PaymentEventProducer;
import com.paymentgateway.payment.repository.PaymentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PaymentService {

    private final PaymentRepository paymentRepository;
    private final PaymentEventProducer paymentEventProducer;

    public PaymentService(
            PaymentRepository paymentRepository,
            PaymentEventProducer paymentEventProducer) {

        this.paymentRepository = paymentRepository;
        this.paymentEventProducer = paymentEventProducer;
    }



    public String createPayment(
            CreatePaymentRequest request) {

        Payment payment = new Payment();

        payment.setPaymentId(
                UUID.randomUUID().toString());

        payment.setMerchantId(
                request.getMerchantId());

        payment.setAmount(
                request.getAmount());

        payment.setCurrency(
                request.getCurrency());

        payment.setPaymentMethod(
                request.getPaymentMethod());

        payment.setStatus("CREATED");

        paymentRepository.save(payment);

        paymentEventProducer.publishPaymentCreatedEvent(
                "Payment Created : "
                        + payment.getPaymentId());

        return "Payment Created Successfully";
    }

    public Payment getPaymentById(Long id) {

        return paymentRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException(
                                "Payment not found"));
    }

    public List<Payment> getAllPayments() {

        return paymentRepository.findAll();
    }

    public String cancelPayment(Long id) {

        Payment payment =
                paymentRepository.findById(id)
                        .orElseThrow(() ->
                                new RuntimeException(
                                        "Payment not found"));

        payment.setStatus("CANCELLED");

        paymentRepository.save(payment);

        return "Payment Cancelled Successfully";
    }
}