package com.cars24.csms.controllers;

import com.cars24.csms.data.entities.CustomerEntity;
import com.cars24.csms.data.req.CreateCustomerRequest;
import com.cars24.csms.data.req.DeleteCustomerRequest;
import com.cars24.csms.data.req.GetCustomerRequest;
import com.cars24.csms.data.req.UpdateCustomerRequest;
import com.cars24.csms.data.resp.*;
import com.cars24.csms.services.CustomerService;
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


    @GetMapping("/profile/{customer_id}")
    public ResponseEntity<CustomerEntity> getCustomer(@Valid @PathVariable Integer customer_id)
    {
       GetCustomerResponse getCustomerResponse=new GetCustomerResponse();
       log.info("[In get controller] getCustomerRequest{}",customer_id);
       CustomerEntity customerEntity=customerService.getCustomer(customer_id);
       return ResponseEntity.ok().body(customerEntity);
    }


    @PostMapping("/addCustomer")

    public ResponseEntity<ApiResponse> createCustomer(@Valid @RequestBody CreateCustomerRequest createCustomerRequest) //because we are using it there
    {
//        System.out.println("[createsCustomer] createCustomerRequest{}"+createCustomerRequest);
//        CreateCustomerResponse res=new CreateCustomerResponse();

        log.info("[IN CONTROLLER] createCustomerRequest{}",createCustomerRequest);
        return customerService.createCustomer(createCustomerRequest);
//        return ResponseEntity.ok().body(res);
//        return null ;
    }
    @DeleteMapping("/deleteCustomer/{customer_id}")
    public ResponseEntity<CustomerEntity> deleteCustomer(@Valid @PathVariable Integer customer_id)
    {
        DeleteCustomerResponse deleteCustomerResponse=new DeleteCustomerResponse();
        log.info("[IN DELETE CONTROLLER] deleteCustomerRequest{}",customer_id);
        CustomerEntity customerEntity=customerService.deleteCustomer(customer_id);
        return ResponseEntity.ok().body(customerEntity);

    }
/*
    @PutMapping("/updateCustomer/{customer_id}")

    public ResponseEntity<UpdateCustomerResponse> updateCustomer(Integer customer_id)
    {
        UpdateCustomerResponse updateCustomerResponse=new UpdateCustomerResponse();
        log.info("[Update Customer Controller]updateCustomerRequest{}",customer_id);
        customerService.updateCustomer(customer_id);
        return ResponseEntity.ok().body(updateCustomerResponse);


    }*/
}
