package com.bank.auth.service;

import com.bank.auth.dto.JwtResponse;
import com.bank.auth.dto.LoginRequest;
import com.bank.auth.dto.RegisterRequest;
import com.bank.auth.entity.User;
import com.bank.auth.repository.UserRepository;
import com.bank.auth.util.JwtUtil;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;

    public AuthService(UserRepository repository,
                       PasswordEncoder passwordEncoder) {

        this.repository = repository;
        this.passwordEncoder = passwordEncoder;

    }

    // Register Customer

    public String register(RegisterRequest request) {

        if (repository.existsByEmail(request.getEmail())) {

            throw new RuntimeException("Email already exists");

        }

        User user = new User();

        user.setCustomerName(request.getCustomerName());

        user.setEmail(request.getEmail());

        user.setPassword(passwordEncoder.encode(request.getPassword()));

        user.setMobile(request.getMobile());

        user.setRole("CUSTOMER");

        repository.save(user);

        return "Customer Registered Successfully";

    }

    // Login

    public JwtResponse login(LoginRequest request) {

        User user = repository.findByEmail(request.getEmail())

                .orElseThrow(() -> new RuntimeException("Invalid Email"));

        if (!passwordEncoder.matches(request.getPassword(),
                user.getPassword())) {

            throw new RuntimeException("Invalid Password");

        }

        String token = JwtUtil.generateToken(user.getEmail());

        return new JwtResponse(token);

    }

}