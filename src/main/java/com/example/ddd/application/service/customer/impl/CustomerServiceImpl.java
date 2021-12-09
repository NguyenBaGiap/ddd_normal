package com.example.ddd.application.service.customer.impl;

import com.example.ddd.application.service.customer.CustomerService;
import com.example.ddd.controller.customer.dto.request.CustomerRequestDTO;
import com.example.ddd.domain.model.authentication.CustomUserDetails;
import com.example.ddd.domain.model.customer.Customer;
import com.example.ddd.domain.repository.customer.CustomerRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.Optional;


@Service
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String mobileNumber) throws UsernameNotFoundException {
        return customerRepository
                .findByMobileNumber(mobileNumber)
                .map(CustomUserDetails::new)
                .orElse(null);
    }

    @Override
    public Optional<Customer> findByMobileNumber(String mobileNumber) {
        return customerRepository.findByMobileNumber(mobileNumber);

    }

    @Override
    @Transactional(rollbackOn = Exception.class)
    public Customer registerCustomer(CustomerRequestDTO requestDTO) {
        return customerRepository.
                initialCustomer(
                        Customer.builder()
                                .mobileNumber(requestDTO.getMobileNumber())
                                .build());
    }
}
