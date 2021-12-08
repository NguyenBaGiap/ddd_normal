package com.example.ddd.controller.admin;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/auth")
public class AdminController {

    @RequestMapping(value = "/test", method = RequestMethod.POST)
    public String testAuth(){
       return "login here...";
    }
}
