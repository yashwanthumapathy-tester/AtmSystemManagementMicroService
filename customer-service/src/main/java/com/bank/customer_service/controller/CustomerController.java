package com.bank.customer_service.controller;

import com.bank.customer_service.entity.Customer;
import com.bank.customer_service.service.CustomerService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    private final CustomerService service;

    public CustomerController(CustomerService service) {

        this.service = service;

    }

    // Create Customer
    @PostMapping
    public Customer saveCustomer(@Valid @RequestBody Customer customer) {

        return service.saveCustomer(customer);

    }

    // Get Customer
    @GetMapping("/{id}")
    public Customer getCustomer(@PathVariable Long id) {

        return service.getCustomer(id);

    }

    // Get All Customers
    @GetMapping
    public List<Customer> getAllCustomers() {

        return service.getAllCustomers();

    }

    // Update Customer
    @PutMapping("/{id}")
    public Customer updateCustomer(@PathVariable Long id,
                                   @RequestBody Customer customer) {

        return service.updateCustomer(id, customer);

    }

    // Delete Customer
    @DeleteMapping("/{id}")
    public String deleteCustomer(@PathVariable Long id) {

        return service.deleteCustomer(id);

    }

}