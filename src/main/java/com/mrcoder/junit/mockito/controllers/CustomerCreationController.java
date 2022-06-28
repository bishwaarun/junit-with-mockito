package com.mrcoder.junit.mockito.controllers;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerCreationController {

    @PostMapping(value = "/createCustomer")
    public String createCustomer(){
        return "New customer created.";
    }
}
