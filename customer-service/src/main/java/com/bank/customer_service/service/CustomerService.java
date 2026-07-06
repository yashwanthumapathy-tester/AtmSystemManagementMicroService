package com.bank.customer_service.service;

import com.bank.customer_service.entity.Customer;
import com.bank.customer_service.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    private final CustomerRepository repository;

    public CustomerService(CustomerRepository repository) {
        this.repository = repository;
    }

    // Create Customer
    public Customer saveCustomer(Customer customer) {
        return repository.save(customer);
    }

    // Get Customer By ID
    public Customer getCustomer(Long id) {

        return repository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Customer Not Found"));

    }

    // Get All Customers
    public List<Customer> getAllCustomers() {

        return repository.findAll();

    }

    // Update Customer
    public Customer updateCustomer(Long id, Customer customer) {

        Customer existing = getCustomer(id);

        existing.setFirstName(customer.getFirstName());
        existing.setLastName(customer.getLastName());
        existing.setEmail(customer.getEmail());
        existing.setPhone(customer.getPhone());
        existing.setAddress(customer.getAddress());

        return repository.save(existing);

    }

    // Delete Customer
    public String deleteCustomer(Long id) {

        repository.deleteById(id);

        return "Customer Deleted Successfully";

    }

}