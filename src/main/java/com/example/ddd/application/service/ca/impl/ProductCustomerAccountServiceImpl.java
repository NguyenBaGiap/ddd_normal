package com.example.ddd.application.service.ca.impl;

import com.example.ddd.application.service.ca.ProductCustomerAccountService;
import com.example.ddd.controller.customer.dto.CustomerDTO;
import com.example.ddd.domain.repository.ca.ProductCustomerAccountRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class ProductCustomerAccountServiceImpl implements ProductCustomerAccountService {
    final ProductCustomerAccountRepository productCustomerAccountRepository;

    public ProductCustomerAccountServiceImpl(ProductCustomerAccountRepository productCustomerAccountRepository) {
        this.productCustomerAccountRepository = productCustomerAccountRepository;
    }

    @Transactional
    @Override
    public String openAccountEKYC(CustomerDTO customerDTO) {
        return "Open Account EKYC";
    }
}
