package com.example.ddd.controller.customer.dto;

import lombok.Data;

@Data
public class CustomerDTO {
    private Long id;
    private String email;
    private String mobileNumber;
    private String fullName;
    private String gender;
    private String pid;
    private String address;
}
