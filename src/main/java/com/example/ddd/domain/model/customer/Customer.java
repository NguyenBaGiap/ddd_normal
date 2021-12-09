package com.example.ddd.domain.model.customer;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Customer {
    private Long id;
    private String email;
    private String mobileNumber;
    private String legalId;
    private Address address;
    private CustomerType type;
}

// Aggregate
