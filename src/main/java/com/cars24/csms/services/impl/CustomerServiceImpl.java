package com.cars24.csms.services.impl;

import com.cars24.csms.data.dao.CustomerDaoImpl;
import com.cars24.csms.data.dao.UserDetailsDaoImpl;
import com.cars24.csms.data.entities.CustomerEntity;
import com.cars24.csms.data.req.CreateCustomerRequest;
import com.cars24.csms.data.req.GetCustomerRequest;
import com.cars24.csms.data.req.UpdateCustomerRequest;
import com.cars24.csms.data.resp.ApiResponse;
import com.cars24.csms.data.resp.CreateCustomerResponse;
import com.cars24.csms.data.resp.GetCustomerResponse;
import com.cars24.csms.data.resp.UpdateCustomerResponse;
import com.cars24.csms.exceptions.UserServiceException;
import com.cars24.csms.services.CustomerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
@Slf4j
public class CustomerServiceImpl implements CustomerService {


//    private static final Logger log = LoggerFactory.getLogger(CustomerServiceImpl.class);
    private final CustomerDaoImpl customerDao;
    private  final UserDetailsDaoImpl userDetailsDao;


//
//    public CreateCustomerResponse createCustomer(CreateCustomerRequest createCustomerRequest) {
////        CustomerDaoImpl customerDao=new CustomerDaoImpl();
//        customerDao.createCustomer(createCustomerRequest);
//        log.info("[Customer Service]CustomerService{}",createCustomerRequest);
//        return null;
//    }

    public ResponseEntity<ApiResponse> getCustomer(Integer customer_id)
    {
        ApiResponse apiResponse=new ApiResponse();

        GetCustomerResponse getCustomerResponse= customerDao.getCustomer(customer_id);
        Map<String,Object> messageResponse=new HashMap<>();
        messageResponse.put("name",getCustomerResponse.getName());
        messageResponse.put("email",getCustomerResponse.getEmail());
        messageResponse.put("address",getCustomerResponse.getAddress());
        messageResponse.put("phone",getCustomerResponse.getPhone());

        apiResponse.setStatusCode(HttpStatus.OK.value());
        apiResponse.setService("Get customer - "+HttpStatus.OK.value());
        apiResponse.setMessage("Get user successful");
        apiResponse.setData(messageResponse);
        apiResponse.setSuccess(true);

        log.info("[GetCustomerService]CustomerService{}",customer_id);

        return ResponseEntity.ok().body(apiResponse);

    }

    @Override
    public ResponseEntity<ApiResponse> deleteCustomer(Integer customer_id) {
        ApiResponse apiResponse=new ApiResponse();

       customerDao.deleteCustomer(customer_id);
        log.info("[IN DELETECUSTOMERDAO]CustomerService{}",customer_id);
        apiResponse.setStatusCode(HttpStatus.OK.value());
        apiResponse.setSuccess(true);
        apiResponse.setMessage("Profile deleted successfully");
        apiResponse.setData(null);
        apiResponse.setService("Customer - "+HttpStatus.OK.value());
        return ResponseEntity.ok().body(apiResponse);
    }

    @Override
    public boolean existUser(String username) {
        return false;
    }


//    @Override
//    public UpdateCustomerResponse updateCustomer(UpdateCustomerRequest updateCustomerRequest) {
//        return null;
//    }


    public ResponseEntity<ApiResponse> createCustomer(CreateCustomerRequest createCustomerRequest)
    {
        log.info("[CreateCustomer] in service: {}",createCustomerRequest);
        ApiResponse apiResponse=new ApiResponse();
        boolean userExists=userDetailsDao.existUser(createCustomerRequest.getEmail());
        log.info("[createCustomer] in Service userExists: {}",userExists);
        if(userExists)
        {
            boolean userInCustomer=customerDao.checkIfEmailExists((createCustomerRequest.getEmail()));
            log.info("[create Employee] in service userInCustomer: {}",userInCustomer);

            if(!userInCustomer)
            {
                apiResponse.setStatusCode(HttpStatus.OK.value());
                apiResponse.setSuccess(true);
                apiResponse.setMessage("Profile created successfully");
                apiResponse.setData(null);
                apiResponse.setService("App user - "+HttpStatus.OK.value());
                Integer userId= userDetailsDao.getUserId(createCustomerRequest.getEmail());
                customerDao.createCustomer(createCustomerRequest,userId);

            }
            else{
                throw new UserServiceException("Profile already exists");

            }
        }
        else {
            throw new UserServiceException("User doesnot exists");

        }
        return ResponseEntity.ok().body(apiResponse);

    }


}
