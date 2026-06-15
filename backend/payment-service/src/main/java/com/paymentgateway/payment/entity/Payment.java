package com.paymentgateway.payment.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "payments")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String paymentId;

    private Long merchantId;

    private BigDecimal amount;

    private String currency;

    private String paymentMethod;

    private String status;

    public Payment() {
    }
}