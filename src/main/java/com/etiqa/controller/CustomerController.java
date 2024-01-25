package com.etiqa.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.etiqa.domain.Customer;
import com.etiqa.service.CustomerService;
import com.etiqa.service.dto.CustomerDTO;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("")
public class CustomerController {

    private final Logger log = LoggerFactory.getLogger(CustomerController.class);

    @Autowired
    private CustomerService customerService;

    @PutMapping("customerRegistration")
    @ResponseStatus(HttpStatus.CREATED)
    public void customerData(@RequestBody CustomerDTO customerDTO) {
        log.info("REST request to create customer {}", customerDTO);

        customerService.customerData(customerDTO);
    }

    @GetMapping("/customer/{id}")
    public ResponseEntity<Customer> getCustomerData(@PathVariable Long id) {
        log.info("REST request to find Customer By Id {}", id);

        Customer cust = customerService.getCustomerData(id) ;

        return ResponseEntity.ok(cust);
    }

}
