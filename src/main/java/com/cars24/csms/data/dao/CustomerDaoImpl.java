package com.cars24.csms.data.dao;

import com.cars24.csms.data.entities.CustomerEntity;
import com.cars24.csms.data.repositories.CustomerRepository;
import com.cars24.csms.data.req.CreateCustomerRequest;
import com.cars24.csms.data.resp.CreateCustomerResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

        customerRepository.save(customerEntity); //insert statement


        log.info("[CustomerDAO],CustomerDao{}",createCustomerRequest);


        return 0;
    }
}
