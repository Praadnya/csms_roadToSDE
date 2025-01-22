package com.cars24.csms.data.dao;

import com.cars24.csms.data.entities.CustomerEntity;
import com.cars24.csms.data.req.CreateCustomerRequest;
import com.cars24.csms.data.req.GetCustomerRequest;
import com.cars24.csms.data.resp.CreateCustomerResponse;
import com.cars24.csms.data.resp.GetCustomerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public interface CustomerDao {

    int createCustomer(CreateCustomerRequest createCustomerRequest);

    CustomerEntity getCustomer(Integer customer_id);

    CustomerEntity deleteCustomer(Integer customer_id);




//    CustomerEntity deleteCustomerById(int customer_id);
}
