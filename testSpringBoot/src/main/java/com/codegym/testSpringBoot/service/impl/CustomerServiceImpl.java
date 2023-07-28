package com.codegym.testSpringBoot.service.impl;

import com.codegym.testSpringBoot.entity.Customer;
import com.codegym.testSpringBoot.repository.CustomerRepository;
import com.codegym.testSpringBoot.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepository customerRepository;
    @Override
    public List<Customer> getAll() {
        return (List<Customer>) customerRepository.findAll();
    }

    @Override
    public boolean create(Customer customer) {
        Customer customer1= customerRepository.save(customer);
        if (customer1.getName().equals(null)){
            return false;
        }
        return true;
    }

    @Override
    public Customer getById(Long id) {
        Customer customer = customerRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("invalid Id")
        );
        return customer;
    }

    @Override
    public void delete(Long id) {
         customerRepository.deleteById(id);
    }
}
