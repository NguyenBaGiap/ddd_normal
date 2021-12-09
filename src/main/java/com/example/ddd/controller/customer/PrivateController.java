package com.example.ddd.controller.customer;

import com.example.ddd.controller.customer.dto.CustomerDTO;
import com.example.ddd.domain.model.authentication.CustomUserDetails;
import com.example.ddd.domain.model.customer.Customer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Slf4j
@RestController
@RequestMapping(value = "/api/private")
@Validated
public class PrivateController {
    final AuthenticationManager authenticationManager;

    public PrivateController(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }
    @RequestMapping(value = "/registers", method = RequestMethod.POST)
    public String registers(@RequestBody @Valid CustomerDTO requestDTO) {
        log.info("request CA: {}", requestDTO);
        return "register cif, ca";
    }

    @RequestMapping(value = "/customer/info", method = RequestMethod.GET)
    public CustomerDTO getCurrentCustomerRegister() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Customer customer = ((CustomUserDetails) principal).getCustomer();
        return CustomerDTO.apply(customer);
    }
}
