package com.cars24.csms.data.dao;

import com.cars24.csms.data.entities.CustomerEntity;
import com.cars24.csms.data.repositories.CustomerRepository;
import com.cars24.csms.data.req.CreateCustomerRequest;
import com.cars24.csms.data.req.GetCustomerRequest;
import com.cars24.csms.data.resp.CreateCustomerResponse;
import com.cars24.csms.data.resp.GetCustomerResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
@RequiredArgsConstructor
@Slf4j

public class CustomerDaoImpl implements CustomerDao {

    private final CustomerRepository customerRepository;



    public int createCustomer(CreateCustomerRequest createCustomerRequest)
    {
        CustomerEntity customerEntity=new CustomerEntity();
        customerEntity.setCustId(0);
        customerEntity.setName(createCustomerRequest.getName());
        customerEntity.setPhone(createCustomerRequest.getPhone());
        customerEntity.setEmail(createCustomerRequest.getEmail());
        customerEntity.setAddress(createCustomerRequest.getAddress());
        customerEntity.setActive(true);
        customerRepository.save(customerEntity); //insert statement
//        customerRepository.(Collections.singleton(createCustomerRequest.getCustId()));

        log.info("[CustomerDAO],CustomerDao{}",createCustomerRequest);


        return 0;
    }

    public GetCustomerResponse getCustomer(int customer_id)
    {
        CustomerEntity customerEntity= customerRepository.findById(customer_id) .orElseThrow(()->new RuntimeException("Customer not found with id: "+customer_id));
        GetCustomerResponse getCustomerResponse=new GetCustomerResponse();
        getCustomerResponse.setName(customerEntity.getName());
        getCustomerResponse.setPhone(customerEntity.getPhone());
        getCustomerResponse.setEmail(customerEntity.getEmail());
        getCustomerResponse.setAddress(customerEntity.getAddress());
        log.info("[getCustomer] in DAO, retrieved record: {}",getCustomerResponse);
//        return 0;
        return null;

    }
}
