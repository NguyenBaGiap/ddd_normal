package com.example.ddd.domain.model.ca;

import com.example.ddd.domain.model.customer.Customer;
import lombok.Data;

import java.time.LocalDate;

@Data
public class ProductCustomerAccount {
    private Long id;
    private String accountNumber;
    private Customer customer;
    private LocalDate openingDate;
    private ProductStatus status;
}
