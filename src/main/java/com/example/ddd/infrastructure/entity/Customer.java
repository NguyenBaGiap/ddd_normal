package com.example.ddd.infrastructure.entity;

import com.example.ddd.domain.model.customer.Address;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Optional;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "CUSTOMER")
public class Customer implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, columnDefinition = "number")
    private Long id;


    @Column(name = "EMAIL", length = 100)
    private String email;

    @Column(name = "MOBILE_NUMBER", length = 100)
    private String mobileNumber;

    @Column(name = "LEGAL_ID", length = 100)
    private String legalId;

    @Column(name = "CITY", length = 100)
    private String city;

    @Column(name = "STREET", length = 100)
    private String street;

    @Column(name = "TYPE", length = 100)
    private String type;

    public static Customer applyCreateCustomer(com.example.ddd.domain.model.customer.Customer customer){
        return Customer
                .builder()
                .mobileNumber(customer.getMobileNumber())
                .email(customer.getEmail())
                .legalId(customer.getLegalId())
                .city(Optional.ofNullable(customer.getAddress()).map(Address::getCity).orElse(null))
                .street(Optional.ofNullable(customer.getAddress()).map(Address::getStreet).orElse(null))
                .legalId(customer.getLegalId())
                .type(Optional.ofNullable(customer.getType()).map(Enum::name).orElse(null))
                .build();
    }

}