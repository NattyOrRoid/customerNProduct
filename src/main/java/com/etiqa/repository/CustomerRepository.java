package com.etiqa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.etiqa.domain.Customer;
import java.util.List;


public interface CustomerRepository extends JpaRepository<Customer, Long> {

    List<Customer> findByFNameAndLName(String fName, String lName);
    
}
