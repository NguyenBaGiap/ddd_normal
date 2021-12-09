package com.example.ddd.controller.customer.dto.response;

import com.example.ddd.domain.model.customer.Customer;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CustomerResponseDTO {
    private String accessToken;
    private String mobileNumber;

    public static CustomerResponseDTO applyCustomer(String accessToken,Customer customer){
        return CustomerResponseDTO.builder()
                .accessToken(accessToken)
                .mobileNumber(customer.getMobileNumber())
                .build();
    }
}
