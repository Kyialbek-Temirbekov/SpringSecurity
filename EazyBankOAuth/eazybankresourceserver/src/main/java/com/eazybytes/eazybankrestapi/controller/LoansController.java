package com.eazybytes.eazybankrestapi.controller;

import com.eazybytes.eazybankrestapi.model.Customer;
import com.eazybytes.eazybankrestapi.model.Loans;
import com.eazybytes.eazybankrestapi.repository.CustomerRepository;
import com.eazybytes.eazybankrestapi.repository.LoanRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LoansController {
    private final LoanRepository loanRepository;
    private final CustomerRepository customerRepository;

    public LoansController(LoanRepository loanRepository, CustomerRepository customerRepository) {
        this.loanRepository = loanRepository;
        this.customerRepository = customerRepository;
    }

    @GetMapping("/myLoans")
    public List<Loans> getLoanDetails(@RequestParam String email) {
        List<Customer> customers = customerRepository.findByEmail(email);
        if (customers != null && !customers.isEmpty()) {
            List<Loans> loans = loanRepository.findByCustomerIdOrderByStartDtDesc(customers.get(0).getId());
            if (loans != null ) {
                return loans;
            }
        }
        return null;
    }
}
