package com.cars24.csms.data.dao;

import com.cars24.csms.data.req.CreateCustomerRequest;
import com.cars24.csms.data.resp.CreateCustomerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public interface CustomerDao {

    int createCustomer(CreateCustomerRequest createCustomerRequest);


}
