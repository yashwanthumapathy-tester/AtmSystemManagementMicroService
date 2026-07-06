package com.bank.account_service.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(AccountNotFoundException.class)
    public ResponseEntity<?> accountNotFound(AccountNotFoundException ex){

        Map<String,Object> map=new HashMap<>();

        map.put("timestamp", LocalDateTime.now());

        map.put("status",404);

        map.put("message",ex.getMessage());

        return new ResponseEntity<>(map,HttpStatus.NOT_FOUND);

    }

    @ExceptionHandler(InsufficientBalanceException.class)
    public ResponseEntity<?> insufficientBalance(InsufficientBalanceException ex){

        Map<String,Object> map=new HashMap<>();

        map.put("timestamp", LocalDateTime.now());

        map.put("status",400);

        map.put("message",ex.getMessage());

        return new ResponseEntity<>(map,HttpStatus.BAD_REQUEST);

    }

    @ExceptionHandler(InvalidAmountException.class)
    public ResponseEntity<?> invalidAmount(InvalidAmountException ex){

        Map<String,Object> map=new HashMap<>();

        map.put("timestamp", LocalDateTime.now());

        map.put("status",400);

        map.put("message",ex.getMessage());

        return new ResponseEntity<>(map,HttpStatus.BAD_REQUEST);

    }

}