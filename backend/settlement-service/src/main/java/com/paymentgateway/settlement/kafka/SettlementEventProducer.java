package com.paymentgateway.settlement.kafka;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class SettlementEventProducer {

    private final KafkaTemplate<String,String>
            kafkaTemplate;

    public SettlementEventProducer(
            KafkaTemplate<String,String>
                    kafkaTemplate) {

        this.kafkaTemplate = kafkaTemplate;
    }

    public void publish(
            String message) {

        kafkaTemplate.send(
                "settlement-created",
                message);

        System.out.println(
                "Settlement Event Published : "
                        + message);
    }
}