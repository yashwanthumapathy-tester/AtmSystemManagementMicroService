package com.bank.auth.controller;

import com.bank.auth.dto.JwtResponse;
import com.bank.auth.dto.LoginRequest;
import com.bank.auth.dto.RegisterRequest;
import com.bank.auth.service.AuthService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService service;

    public AuthController(AuthService service) {

        this.service = service;

    }

    @PostMapping("/register")
    public String register(@Valid @RequestBody RegisterRequest request) {

        return service.register(request);

    }

    @PostMapping("/login")
    public JwtResponse login(@RequestBody LoginRequest request) {

        return service.login(request);

    }

}