package com.example.ddd.controller.customer.dto.request;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

@Data
public class CustomerRequestDTO {
    @NotNull
    @Length(max = 10)
    private String mobileNumber;

    private String utmSource;
    private String utmContent;
    private String utmCampaign;
}
