package com.example.ddd.domain.repository.ca;

import com.example.ddd.domain.model.ca.ProductCustomerAccount;
import com.example.ddd.domain.model.ca.ProductStatus;
import com.example.ddd.domain.model.customer.Customer;
import com.example.ddd.infrastructure.db.ProductCustomerAccountJPARepositoryInterface;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class ProductCustomerAccountRepositoryOnJDBC
        implements ProductCustomerAccountRepository {

    final ProductCustomerAccountJPARepositoryInterface repositoryInterface;

    public ProductCustomerAccountRepositoryOnJDBC(ProductCustomerAccountJPARepositoryInterface repositoryInterface) {
        this.repositoryInterface = repositoryInterface;
    }

    @Override
    public ProductCustomerAccount registerProductEKYC(Customer customer) {
        com.example.ddd.infrastructure.entity.ProductCustomerAccount register = repositoryInterface.save(
                com.example.ddd.infrastructure.entity.ProductCustomerAccount
                        .applyOpenEKYC(
                                ProductCustomerAccount
                                        .builder()
                                        .customer(customer)
                                        .openingDate(LocalDate.now())
                                        .accountNumber(Long.toString(System.currentTimeMillis()))
                                        .status(ProductStatus.E_KYC)
                                        .build()
                        )
        );
        return ProductCustomerAccount
                .builder()
                .id(register.getId())
                .customer(customer)
                .openingDate(register.getOpeningDate())
                .status(ProductStatus.E_KYC)
                .build();
    }
}
