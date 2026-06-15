package com.paymentgateway.transaction.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "transactions")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String transactionId;

    private Long paymentId;

    private Long merchantId;

    private BigDecimal amount;

    private String currency;

    private String status;

    public Transaction() {
    }


}