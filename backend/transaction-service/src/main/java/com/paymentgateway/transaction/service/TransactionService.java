package com.paymentgateway.transaction.service;

import com.paymentgateway.transaction.dto.CreateTransactionRequest;
import com.paymentgateway.transaction.entity.Transaction;
import com.paymentgateway.transaction.repository.TransactionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class TransactionService {

    private final TransactionRepository transactionRepository;

    public TransactionService(
            TransactionRepository transactionRepository) {

        this.transactionRepository = transactionRepository;
    }

    public String createTransaction(
            CreateTransactionRequest request) {

        Transaction transaction = new Transaction();

        transaction.setTransactionId(
                UUID.randomUUID().toString());

        transaction.setPaymentId(
                request.getPaymentId());

        transaction.setMerchantId(
                request.getMerchantId());

        transaction.setAmount(
                request.getAmount());

        transaction.setCurrency(
                request.getCurrency());

        transaction.setStatus("SUCCESS");

        transactionRepository.save(transaction);

        return "Transaction Created Successfully";
    }

    public Transaction getTransactionById(Long id) {

        return transactionRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException(
                                "Transaction not found"));
    }

    public List<Transaction> getAllTransactions() {

        return transactionRepository.findAll();
    }
}