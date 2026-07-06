package com.bank.account_service.client;

import com.bank.account_service.dto.TransactionRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "TRANSACTION-SERVICE")
public interface TransactionClient {

    @PostMapping("/transaction")
    TransactionRequest saveTransaction(@RequestBody TransactionRequest request);

}