package com.eazybytes.eazybankrestapi.controller;

import com.eazybytes.eazybankrestapi.model.Customer;
import com.eazybytes.eazybankrestapi.repository.CustomerRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
    private final CustomerRepository customerRepository;
    private final PasswordEncoder bCryptPasswordEncoder;

    public LoginController(CustomerRepository customerRepository, PasswordEncoder bCryptPasswordEncoder) {
        this.customerRepository = customerRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }
    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody Customer customer) {
        customer.setPwd(bCryptPasswordEncoder.encode(customer.getPwd()));
        Customer savedCustomer;
        ResponseEntity<String> response = null;
        try {
                savedCustomer = customerRepository.save(customer);
                if(savedCustomer.getId()>0) {
                    response = ResponseEntity
                            .status(HttpStatus.CREATED)
                            .body("Given user details successfully registered");
                }
        }
        catch (Exception e) {
            response = ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("An exception occured due to " + e.getMessage());
        }
        return response;
    }
}
