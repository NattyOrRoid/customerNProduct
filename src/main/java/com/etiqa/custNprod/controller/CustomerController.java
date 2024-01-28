package com.etiqa.custNprod.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.etiqa.custNprod.domain.Customer;
import com.etiqa.custNprod.service.CustomerService;
import com.etiqa.custNprod.service.dto.CustomerDTO;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@RestController
@RequestMapping("/custAPI")
public class CustomerController {

    private final Logger log = LoggerFactory.getLogger(CustomerController.class);

    @Autowired
    private CustomerService customerService;

    @PostMapping("/customerRegistration")
    @ResponseStatus(HttpStatus.CREATED)
    public void customerData(@Valid @RequestBody CustomerDTO customerDTO) {
        log.info("REST request to create customer {}", customerDTO);

        customerService.customerData(customerDTO);
    }

    @GetMapping("/customer")
    @ResponseStatus(HttpStatus.OK)
    public List<Customer> getAllCustomerData() {
        log.info("REST request to find all Customer {}");

        List<Customer> cust = customerService.getAllCustomerData() ;

        return cust;
    }

    @GetMapping("/customer/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Customer> getCustomerData(@Valid @PathVariable Long id) {
        log.info("REST request to find Customer By Id {}", id);

        Customer cust = customerService.getCustomerData(id) ;

        return ResponseEntity.ok(cust);
    }

    @PutMapping("/customer/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Customer> updateCustomerData(@Valid @PathVariable CustomerDTO customerDTO) {
        log.info("REST request to update Customer By Id {}", customerDTO.getId());

        Customer cust = customerService.updateCustomerData(customerDTO) ;

        return ResponseEntity.ok(cust);
    }

    @DeleteMapping("/customer/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteCustomerData(@Valid @PathVariable Long id) {
        log.info("REST request to delete Customer By Id {}", id);

        customerService.deleteCustomerData(id) ;
    }

}
