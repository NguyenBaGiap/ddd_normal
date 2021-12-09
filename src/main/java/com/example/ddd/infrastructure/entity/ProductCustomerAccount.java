package com.example.ddd.infrastructure.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "PRODUCT_CUSTOMER_ACCOUNT")
public class ProductCustomerAccount implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, columnDefinition = "number")
    private Long id;

    @Column(name = "account_number", length = 20)
    private String accountNumber;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @Column(name = "opening_date",  columnDefinition = "datetime")
    private LocalDate openingDate;

    @Column(name = "status", length = 20)
    private String status;

    public static ProductCustomerAccount applyOpenEKYC(com.example.ddd.domain.model.ca.ProductCustomerAccount ca) {
        return ProductCustomerAccount
                .builder()
                .accountNumber(ca.getAccountNumber())
                .customer(Customer.builder().id(ca.getId()).build())
                .openingDate(ca.getOpeningDate())
                .status("EKYC")
                .build();
    }
}
