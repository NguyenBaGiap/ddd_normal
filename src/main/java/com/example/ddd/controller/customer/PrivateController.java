package com.example.ddd.controller.customer;

import com.example.ddd.controller.customer.dto.CustomerDTO;
import lombok.extern.slf4j.Slf4j;
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

    @RequestMapping(value = "/registers", method = RequestMethod.POST)
    public String registers(@RequestBody @Valid CustomerDTO requestDTO) {
        log.info("request CIF, CA: {}", requestDTO);
        return "register cif, ca";
    }

    @RequestMapping(value = "/customer/info", method = RequestMethod.GET)
    public String getCurrentCustomerRegister() {
        return "get customer info";
    }
}
