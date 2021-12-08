package com.example.ddd.infrastructure.entity;

import com.example.ddd.infrastructure.comon.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "PRODUCT_CUSTOMER_ACCOUNT")
public class ProductCustomerAccount extends BaseEntity {
    @Column(name = "account_number", length = 20)
    private String accountNumber;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @Column(name = "opening_date",  columnDefinition = "datetime")
    private LocalDate openingDate;

    @Column(name = "status", length = 20)
    private String status;
}
