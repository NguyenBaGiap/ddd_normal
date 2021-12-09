package com.example.ddd.infrastructure.db;

import com.example.ddd.infrastructure.entity.ProductCustomerAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductCustomerAccountJPARepositoryInterface
        extends JpaRepository<ProductCustomerAccount, Long> {
}
