package com.example.ddd.controller.customer;

import com.example.ddd.application.service.customer.CustomerService;
import com.example.ddd.controller.customer.dto.request.CustomerRequestDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Slf4j
@RestController
@RequestMapping(value = "/api/public")
@Validated
public class PublicController {
    final CustomerService customerService;

    public PublicController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @RequestMapping(value = "/register/step01", method = RequestMethod.POST)
    public String registerStepOne(@RequestBody @Valid CustomerRequestDTO requestDTO) {
        log.info("request: {}", requestDTO);
        customerService.registerCustomer(requestDTO);
        return "testt";
    }

}
