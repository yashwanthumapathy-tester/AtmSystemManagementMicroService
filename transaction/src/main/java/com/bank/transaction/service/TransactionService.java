package com.bank.transaction.service;

import com.bank.transaction.entity.Transaction;
import com.bank.transaction.repository.TransactionRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TransactionService {

    private final TransactionRepository repository;

    public TransactionService(TransactionRepository repository) {
        this.repository = repository;
    }

    // Save Transaction
    public Transaction saveTransaction(Transaction transaction) {

        transaction.setTransactionDate(LocalDateTime.now());

        return repository.save(transaction);

    }

    // Get Transaction History
    public List<Transaction> getTransactions(Long accountNo) {

        return repository.findByAccountNo(accountNo);

    }

}