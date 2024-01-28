package com.etiqa.custNprod.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.etiqa.custNprod.domain.Customer;
import java.util.Optional;

@Repository
@EnableJpaRepositories
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    Optional<Customer> findByFNameAndLName(String fName, String lName);
    
}
