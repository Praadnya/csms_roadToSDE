package com.cars24.csms.services;

import com.cars24.csms.data.entities.CustomerEntity;
import com.cars24.csms.data.req.CreateCustomerRequest;
import com.cars24.csms.data.req.GetCustomerRequest;
import com.cars24.csms.data.req.UpdateCustomerRequest;
import com.cars24.csms.data.resp.CreateCustomerResponse;
import com.cars24.csms.data.resp.GetCustomerResponse;
import com.cars24.csms.data.resp.UpdateCustomerResponse;
import org.springframework.stereotype.Service;

@Service
public interface CustomerService {
    CreateCustomerResponse createCustomer(CreateCustomerRequest createCustomerRequest );
    CustomerEntity getCustomer(Integer customer_id);

    CustomerEntity deleteCustomer(Integer customer_id);

//    UpdateCustomerResponse updateCustomer(UpdateCustomerRequest updateCustomerRequest);

}
