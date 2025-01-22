package com.cars24.csms.services.impl;

import com.cars24.csms.data.dao.CustomerDaoImpl;
import com.cars24.csms.data.entities.CustomerEntity;
import com.cars24.csms.data.req.CreateCustomerRequest;
import com.cars24.csms.data.req.GetCustomerRequest;
import com.cars24.csms.data.resp.CreateCustomerResponse;
import com.cars24.csms.data.resp.GetCustomerResponse;
import com.cars24.csms.services.CustomerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
@RequiredArgsConstructor
@Slf4j
public class CustomerServiceImpl implements CustomerService {


//    private static final Logger log = LoggerFactory.getLogger(CustomerServiceImpl.class);
    private final CustomerDaoImpl customerDao;


    public CreateCustomerResponse createCustomer(CreateCustomerRequest createCustomerRequest) {
//        CustomerDaoImpl customerDao=new CustomerDaoImpl();
        customerDao.createCustomer(createCustomerRequest);
        log.info("[Customer Service]CustomerService{}",createCustomerRequest);
        return null;
    }

    public CustomerEntity getCustomer(Integer customer_id)
    {
        CustomerEntity resp= customerDao.getCustomer(customer_id);
        log.info("[GetCustomerService]CustomerService{}",customer_id);
        return resp;

    }
}
