package com.paymentgateway.transaction.controller;

import com.paymentgateway.transaction.dto.CreateTransactionRequest;
import com.paymentgateway.transaction.entity.Transaction;
import com.paymentgateway.transaction.service.TransactionService;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/transactions")
public class TransactionController {

    private final TransactionService transactionService;

    public TransactionController(
            TransactionService transactionService) {

        this.transactionService = transactionService;
    }

    @PostMapping
    public String createTransaction(
            @RequestBody CreateTransactionRequest request) {

        return transactionService.createTransaction(
                request);
    }

    @GetMapping("/{id}")
    public Transaction getTransactionById(
            @PathVariable Long id) {

        return transactionService.getTransactionById(id);
    }

    @GetMapping
    public List<Transaction> getAllTransactions() {

        return transactionService.getAllTransactions();
    }
}