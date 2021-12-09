package com.example.ddd.domain.repository.customer;


import com.example.ddd.domain.model.customer.Customer;

import java.util.Optional;

public interface CustomerRepository {
    Customer initialCustomer(Customer customer);
    Optional<Customer> findByMobileNumber(String mobileNumber);
}
