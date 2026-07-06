package com.bank.transaction.controller;

import com.bank.transaction.entity.Transaction;
import com.bank.transaction.service.TransactionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transaction")
public class TransactionController {

    private final TransactionService service;

    public TransactionController(TransactionService service) {
        this.service = service;
    }

    // Save Transaction
    @PostMapping
    public Transaction save(@RequestBody Transaction transaction) {

        return service.saveTransaction(transaction);

    }

    // Transaction History
    @GetMapping("/{accountNo}")
    public List<Transaction> history(@PathVariable Long accountNo) {

        return service.getTransactions(accountNo);

    }

}