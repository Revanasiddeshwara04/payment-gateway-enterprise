package com.paymentgateway.notification.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class PaymentNotificationConsumer {

    @KafkaListener(
            topics = "payment-created",
            groupId = "notification-group")
    public void consume(String message) {

        System.out.println(
                "================================");

        System.out.println(
                "PAYMENT EVENT RECEIVED");

        System.out.println(message);

        System.out.println(
                "================================");
    }
}