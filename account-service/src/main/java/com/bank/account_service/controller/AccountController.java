package com.bank.account_service.controller;

import com.bank.account_service.dto.DepositRequest;
import com.bank.account_service.dto.TransferRequest;
import com.bank.account_service.dto.WithdrawRequest;
import com.bank.account_service.entity.Account;
import com.bank.account_service.service.AccountService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/account")
public class AccountController {

    private final AccountService service;

    public AccountController(AccountService service) {
        this.service = service;
    }

    // Create Account
    @PostMapping("/create")
    public Account createAccount(@RequestBody Account account) {

        return service.createAccount(account);

    }

    // Deposit
    @PostMapping("/deposit")
    public Account deposit(@RequestBody DepositRequest request) {

        return service.deposit(request);

    }

    // Withdraw
    @PostMapping("/withdraw")
    public Account withdraw(@RequestBody WithdrawRequest request) {

        return service.withdraw(request);

    }

    // Fund Transfer
    @PostMapping("/transfer")
    public String transfer(@RequestBody TransferRequest request) {

        return service.transfer(request);

    }

    // Balance Inquiry
    @GetMapping("/balance/{accountNo}")
    public Double balance(@PathVariable Long accountNo) {

        return service.checkBalance(accountNo);

    }

    // View All Accounts
    @GetMapping("/all")
    public List<Account> allAccounts() {

        return service.getAllAccounts();

    }

}