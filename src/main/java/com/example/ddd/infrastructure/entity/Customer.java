package com.example.ddd.infrastructure.entity;

import com.example.ddd.infrastructure.comon.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "CUSTOMER")
public class Customer extends BaseEntity {
    @Column(name = "EMAIL", length = 100)
    private String email;

    @Column(name = "MOBILE_NUMBER", length = 100)
    private String mobileNumber;

    @Column(name = "LEGAL_ID", length = 100)
    private String legalId;

    @Column(name = "ADDRESS", length = 100)
    private String address;

    @Column(name = "TYPE", length = 100)
    private String type;

    public static Customer applyCreateCustomer(com.example.ddd.domain.model.customer.Customer customer){
        return Customer
                .builder()
                .mobileNumber(customer.getMobileNumber())
                .email(customer.getEmail())
                .legalId(customer.getLegalId())
                .address(customer.getAddress())
                .legalId(customer.getLegalId())
                .type(customer.getType() != null ?customer.getType().name() : null)
                .build();
    }


}