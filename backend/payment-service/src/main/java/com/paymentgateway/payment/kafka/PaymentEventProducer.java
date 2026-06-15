package com.paymentgateway.payment.kafka;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class PaymentEventProducer {

    private final KafkaTemplate<String, String> kafkaTemplate;

    public PaymentEventProducer(
            KafkaTemplate<String, String> kafkaTemplate) {

        this.kafkaTemplate = kafkaTemplate;
    }

    public void publishPaymentCreatedEvent(
            String message) {

        kafkaTemplate.send(
                "payment-created",
                message);

        System.out.println(
                "Payment Event Published: "
                        + message);
    }
}