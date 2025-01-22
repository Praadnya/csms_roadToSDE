package com.cars24.csms.data.dao;

import com.cars24.csms.data.entities.CustomerEntity;
import com.cars24.csms.data.repositories.CustomerRepository;
import com.cars24.csms.data.req.CreateCustomerRequest;
import com.cars24.csms.data.resp.DeleteCustomerResponse;
import com.cars24.csms.data.resp.GetCustomerResponse;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

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

    public CustomerEntity getCustomer(Integer customer_id)
    {
        CustomerEntity customerEntity= customerRepository.findById(customer_id) .orElseThrow(()->new RuntimeException("Customer not found with id: "+customer_id));
        GetCustomerResponse getCustomerResponse=new GetCustomerResponse();
        getCustomerResponse.setName(customerEntity.getName());
        getCustomerResponse.setPhone(customerEntity.getPhone());
        getCustomerResponse.setEmail(customerEntity.getEmail());
        getCustomerResponse.setAddress(customerEntity.getAddress());
        log.info("[getCustomer] in DAO, retrieved record: {}",getCustomerResponse);
//        return 0;
        return customerEntity;

    }

    @Override
    public void deleteCustomer(Integer customer_id) {
       customerRepository.deleteById(customer_id);

    }

    @Override
    public CustomerEntity deleteCustomerById(int customer_id) {
        // Retrieve the entity by its ID
        Optional<CustomerEntity> customerEntityOptional = customerRepository.findById(customer_id);
        System.out.println(customerEntityOptional.get());
        if (customerEntityOptional.isPresent()) {
            CustomerEntity customerEntity = customerEntityOptional.get();

            // Perform the delete operation
            customerRepository.delete(customerEntity);

            // Return the deleted entity
            return customerEntity;
        } else {
            throw new EntityNotFoundException("Customer with ID " + customer_id + " not found.");
        }
    }

}
