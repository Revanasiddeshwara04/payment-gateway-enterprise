package com.paymentgateway.transaction.repository;

import com.paymentgateway.transaction.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository
        extends JpaRepository<Transaction, Long> {
}