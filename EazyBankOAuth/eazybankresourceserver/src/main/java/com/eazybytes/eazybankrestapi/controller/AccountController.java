package com.eazybytes.eazybankrestapi.controller;

import com.eazybytes.eazybankrestapi.model.Accounts;
import com.eazybytes.eazybankrestapi.model.Customer;
import com.eazybytes.eazybankrestapi.repository.AccountsRepository;
import com.eazybytes.eazybankrestapi.repository.CustomerRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AccountController {
    private final AccountsRepository accountsRepository;
    private final CustomerRepository customerRepository;

    public AccountController(AccountsRepository accountsRepository, CustomerRepository customerRepository) {
        this.accountsRepository = accountsRepository;
        this.customerRepository = customerRepository;
    }

    @GetMapping("/myAccount")
    public Accounts getAccountDetails(@RequestParam String email) {
        List<Customer> customers = customerRepository.findByEmail(email);
        if (customers != null && !customers.isEmpty()) {
            Accounts accounts = accountsRepository.findByCustomerId(customers.get(0).getId());
            if (accounts != null) {
                return accounts;
            }
        }
        return null;
    }
}
