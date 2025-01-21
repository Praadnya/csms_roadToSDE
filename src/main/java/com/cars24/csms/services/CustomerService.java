package com.cars24.csms.services;

import com.cars24.csms.data.req.CreateCustomerRequest;
import com.cars24.csms.data.req.GetCustomerRequest;
import com.cars24.csms.data.resp.CreateCustomerResponse;
import org.springframework.stereotype.Service;

@Service
public interface CustomerService {
    CreateCustomerResponse createCustomer(CreateCustomerRequest createCustomerRequest );
    CreateCustomerResponse getCustomer(int customer_id);
}
