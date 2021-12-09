package com.example.ddd.domain.model.customer;

import lombok.Value;

@Value
public class Address {
    String street;
    String city;

    public Address(String street, String city) {
        this.street = street;
        this.city = city;
    }
}

// Value Object : https://dzone.com/articles/value-objects
