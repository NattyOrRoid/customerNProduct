package com.etiqa.service;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import com.etiqa.domain.Customer;
import com.etiqa.repository.CustomerRepository;
import com.etiqa.service.dto.CustomerDTO;

@Service
public class CustomerService {
    private final Logger log = LoggerFactory.getLogger(CustomerService.class);
    
    @Autowired
    private CustomerRepository customerRepository;

    public Customer customerData(CustomerDTO customerDTO) {
        
        List<Customer> existCust = customerRepository.findByFNameAndLName(customerDTO.getFName(), customerDTO.getFName());

        // if() {
        //     throw new ExceptionHandler("");
        // }

        Customer cust = new Customer();
        cust.setFName(customerDTO.getFName());
        cust.setLName(customerDTO.getLName());
        cust.setPersonalMail(customerDTO.getPersonalMail());
        cust.setOfficeMail(customerDTO.getOfficeMail());


        return null;
    }

    @Transactional(readOnly = true)
    public Customer getCustomerData(Long id){
        Customer cust = customerRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found with id " + id));

        return cust;
    }
}
