package com.example.ddd.domain.repository.ca;

import com.example.ddd.domain.model.ca.ProductCustomerAccount;
import com.example.ddd.domain.model.customer.Customer;

public interface ProductCustomerAccountRepository {
    ProductCustomerAccount registerProductEKYC(Customer customer);
}
