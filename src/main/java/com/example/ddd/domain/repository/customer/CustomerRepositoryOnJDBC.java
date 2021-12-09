package com.example.ddd.domain.repository.customer;

import com.example.ddd.domain.model.customer.Address;
import com.example.ddd.domain.model.customer.Customer;
import com.example.ddd.infrastructure.db.CustomerJPARepositoryInterface;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class CustomerRepositoryOnJDBC implements CustomerRepository{
    final CustomerJPARepositoryInterface customerJPARepositoryInterface;

    public CustomerRepositoryOnJDBC(CustomerJPARepositoryInterface customerJPARepositoryInterface) {
        this.customerJPARepositoryInterface = customerJPARepositoryInterface;
    }

    @Override
    public Customer initialCustomer(Customer customer) {
        com.example.ddd.infrastructure.entity.Customer saved = customerJPARepositoryInterface.save(
                com.example.ddd.infrastructure.entity.Customer.applyCreateCustomer(customer)
        );
        return convertToCustomer(saved);
    }

    @Override
    public Optional<Customer> findByMobileNumber(String mobileNumber) {
        return customerJPARepositoryInterface
                .findByMobileNumber(mobileNumber)
                .map(this::convertToCustomer);
    }

    private Customer convertToCustomer(com.example.ddd.infrastructure.entity.Customer entity){
        return Customer
                .builder()
                .id(entity.getId())
                .email(entity.getEmail())
                .mobileNumber(entity.getMobileNumber())
                .address(new Address(entity.getStreet(), entity.getCity()))
                .legalId(entity.getLegalId())
                .build();
    }
}
