package com.example.ddd.controller.customer.dto;

import com.example.ddd.domain.model.customer.Customer;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CustomerDTO {
    private Long id;
    private String email;
    private String mobileNumber;
    private String pid;

    public static CustomerDTO apply(Customer customer) {
        return CustomerDTO
                .builder()
                .id(customer.getId())
                .email(customer.getEmail())
                .mobileNumber(customer.getMobileNumber())
                .pid(customer.getLegalId())
                .build();
    }
    public static Customer applyRequest(CustomerDTO dto) {
        return Customer
                .builder()
                .id(dto.getId())
                .email(dto.getEmail())
                .mobileNumber(dto.getMobileNumber())
                .legalId(dto.getPid())
                .build();

    }
}
