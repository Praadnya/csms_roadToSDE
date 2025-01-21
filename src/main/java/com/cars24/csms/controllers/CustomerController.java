package com.cars24.csms.controllers;

import com.cars24.csms.data.req.CreateCustomerRequest;
import com.cars24.csms.data.resp.CreateCustomerResponse;
import com.cars24.csms.services.impl.CustomerServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

//import javax.validation.Valid;


@RestController
@RequiredArgsConstructor
@RequestMapping("/customer")
@Validated //without all these it won't pick up the validations
@Slf4j //for logging

public class CustomerController {


    private final CustomerServiceImpl customerService;


    @GetMapping("/profile")
    public String getCustomer()
    {
        return "Welcome to Spring!!";
    }


    @PostMapping("/addCustomer")

    public ResponseEntity<CreateCustomerResponse> createCustomer(@Valid @RequestBody CreateCustomerRequest createCustomerRequest) //because we are using it there
    {
//        System.out.println("[createsCustomer] createCustomerRequest{}"+createCustomerRequest);
        CreateCustomerResponse res=new CreateCustomerResponse();

        log.info("[IN CONTROLLER] createCustomerRequest{}",createCustomerRequest);
        customerService.createCustomer(createCustomerRequest);
        return ResponseEntity.ok().body(res);
//        return null ;
    }
}
