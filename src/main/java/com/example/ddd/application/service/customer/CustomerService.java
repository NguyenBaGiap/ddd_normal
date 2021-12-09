package com.example.ddd.application.service.customer;

import com.example.ddd.controller.customer.dto.request.CustomerRequestDTO;
import com.example.ddd.domain.model.customer.Customer;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.Optional;

public interface CustomerService extends UserDetailsService {
    Optional<Customer> findByMobileNumber(String mobileNumber);
    Customer registerCustomer(CustomerRequestDTO requestDTO);
}
