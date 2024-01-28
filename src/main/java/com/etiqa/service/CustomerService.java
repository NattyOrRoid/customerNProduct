package com.etiqa.service;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import com.etiqa.domain.Customer;
import com.etiqa.helper.ExceptionHandler;
import com.etiqa.repository.CustomerRepository;
import com.etiqa.service.dto.CustomerDTO;

@Service
public class CustomerService {
    private final Logger log = LoggerFactory.getLogger(CustomerService.class);
    
    @Autowired
    private CustomerRepository customerRepository;

    public void customerData(CustomerDTO customerDTO) {
        
        Customer existCust = customerRepository.findByFNameAndLName(customerDTO.getFName(), customerDTO.getLName());

        if(existCust != null) {
            throw new ExceptionHandler("Customer already exist");
        }

        Customer cust = new Customer();
        cust.setFName(customerDTO.getFName());
        cust.setLName(customerDTO.getLName());
        cust.setPersonalMail(customerDTO.getPersonalMail());
        cust.setOfficeMail(customerDTO.getOfficeMail());
    }

    public Customer updateCustomerData(CustomerDTO customerDTO) {
        Customer cust = customerRepository.findById(customerDTO.getId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found with id " + customerDTO.getId()));

        log.info("Current customer data {}", cust);

        cust.setFName(customerDTO.getFName());
        cust.setLName(customerDTO.getLName());
        cust.setPersonalMail(customerDTO.getPersonalMail());
        cust.setOfficeMail(customerDTO.getOfficeMail());

        return cust;
    }

    @Transactional(readOnly = true)
    public List<Customer> getAllCustomerData(){
        List<Customer> cust = new ArrayList<Customer>();
        
        cust = customerRepository.findAll();

        if(cust.isEmpty()){
            throw new NullPointerException("There's no customer data.");
        }

        return cust;
    }

    @Transactional(readOnly = true)
    public Customer getCustomerData(Long id){
        Customer cust = customerRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found with id " + id));

        return cust;
    }

    public void deleteCustomerData(Long id){
        customerRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found with id " + id));
    }
}
