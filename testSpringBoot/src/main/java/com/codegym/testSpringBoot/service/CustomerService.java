package com.codegym.testSpringBoot.service;

import com.codegym.testSpringBoot.entity.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> getAll();

    boolean create(Customer customer);

    Customer getById(Long id);

    void delete(Long id);
}
