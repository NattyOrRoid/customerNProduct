package com.etiqa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.etiqa.domain.Customer;
import java.util.Optional;


public interface CustomerRepository extends JpaRepository<Customer, Long> {

    Optional<Customer> findByFNameAndLName(String fName, String lName);
    
}
