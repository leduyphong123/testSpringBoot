package com.codegym.testSpringBoot.repository;

import com.codegym.testSpringBoot.entity.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends CrudRepository<Customer,Long> {
    List<Customer> findByNameLike(String name);
}
