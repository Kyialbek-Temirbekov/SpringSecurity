package com.eazybytes.eazybankrestapi.model;

import jakarta.persistence.*;

@Entity
@Table(name = "authorities")
public class Authority {
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE,generator="native")
    @SequenceGenerator(name = "native",sequenceName = "authorities_id_seq", allocationSize = 1)
    private Long id;
    private String name;
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
