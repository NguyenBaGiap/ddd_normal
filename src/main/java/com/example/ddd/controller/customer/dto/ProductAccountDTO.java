package com.example.ddd.controller.customer.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductAccountDTO {
    private Long customerId;
    private Long productCustomerAccountId;
    private String customerEmail;
    private String customerPid;
    private String customerPhone;
    private String accountNumber;

}
