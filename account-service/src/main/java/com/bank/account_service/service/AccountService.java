package com.bank.account_service.service;

import com.bank.account_service.client.TransactionClient;
import com.bank.account_service.dto.DepositRequest;
import com.bank.account_service.dto.TransactionRequest;
import com.bank.account_service.dto.TransferRequest;
import com.bank.account_service.dto.WithdrawRequest;
import com.bank.account_service.entity.Account;
import com.bank.account_service.exception.AccountNotFoundException;
import com.bank.account_service.exception.InsufficientBalanceException;
import com.bank.account_service.exception.InvalidAmountException;
import com.bank.account_service.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AccountService {

    private final AccountRepository repository;

    private final TransactionClient transactionClient;

//    public AccountService(AccountRepository repository) {
//        this.repository = repository;
//    }

    // Create Account
    public Account createAccount(Account account) {

        if (account.getBalance() == null) {
            account.setBalance(0.0);
        }

        return repository.save(account);
    }

    // Get Account
    public Account getAccount(Long accountNo) {

        return repository.findById(accountNo)
                .orElseThrow(() ->
                        new AccountNotFoundException("Account Not Found"));

    }

    // Get All Accounts
    public List<Account> getAllAccounts() {

        return repository.findAll();

    }

    // Deposit Money
    public Account deposit(DepositRequest requestDto) {

        if(requestDto.getAmount()<=0){

            throw new InvalidAmountException("Amount should be greater than zero");

        }

        Account account = getAccount(requestDto.getAccountNo());

        account.setBalance(account.getBalance() + requestDto.getAmount());

        return repository.save(account);

    }

    // Withdraw Money
    public Account withdraw(WithdrawRequest request) {

        if(request.getAmount()<=0){

            throw new InvalidAmountException("Amount should be greater than zero");

        }

        Account account = getAccount(request.getAccountNo());

        if (account.getBalance() < request.getAmount()) {

            throw new InsufficientBalanceException("Insufficient Balance");

        }

        account.setBalance(account.getBalance() - request.getAmount());

        return repository.save(account);

    }

    // Check Balance
    public Double checkBalance(Long accountNo) {

        return getAccount(accountNo).getBalance();

    }

    // Fund Transfer
    public String transfer(TransferRequest request) {

        Account from = getAccount(request.getFromAccount());

        Account to = getAccount(request.getToAccount());

        if (from.getBalance() < request.getAmount()) {

            throw new RuntimeException("Insufficient Balance");

        }

        from.setBalance(from.getBalance() - request.getAmount());

        to.setBalance(to.getBalance() + request.getAmount());

        repository.save(from);

        repository.save(to);

        return "Fund Transfer Successful";

    }

}