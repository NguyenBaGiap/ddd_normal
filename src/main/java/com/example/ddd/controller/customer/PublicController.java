package com.example.ddd.controller.customer;

import com.example.ddd.application.service.customer.CustomerService;
import com.example.ddd.controller.customer.dto.request.CustomerRequestDTO;
import com.example.ddd.controller.customer.dto.response.CustomerResponseDTO;
import com.example.ddd.domain.model.customer.Customer;
import com.example.ddd.domain.services.sercurity.jwt.JwtTokenProvider;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
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
    final JwtTokenProvider jwtTokenProvider;

    final AuthenticationManager authenticationManager;
    final CustomerService customerService;

    public PublicController(JwtTokenProvider jwtTokenProvider,
                            AuthenticationManager authenticationManager,
                            CustomerService customerService) {
        this.jwtTokenProvider = jwtTokenProvider;
        this.authenticationManager = authenticationManager;
        this.customerService = customerService;
    }

    @RequestMapping(value = "/register/step01", method = RequestMethod.POST)
    public CustomerResponseDTO registerStepOne(@RequestBody @Valid CustomerRequestDTO requestDTO) {
        log.info("request: {}", requestDTO);
        Customer customer = customerService.registerCustomer(requestDTO);
        String jwt = JwtTokenProvider.generateTokenForCustomer(
                customer.getEmail(),
                customer.getMobileNumber(),
                customer.getId()
        );
        return CustomerResponseDTO.applyCustomer(jwt, customer);
    }

}
