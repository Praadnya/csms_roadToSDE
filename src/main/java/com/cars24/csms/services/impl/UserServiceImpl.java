package com.cars24.csms.services.impl;

import com.cars24.csms.data.dao.UserDetailsDao;
import com.cars24.csms.data.dao.UserDetailsDaoImpl;
import com.cars24.csms.data.entities.UserDetailsEntity;
import com.cars24.csms.data.req.SignupUserRequest;
import com.cars24.csms.data.resp.ApiResponse;
import com.cars24.csms.exceptions.UserServiceException;
import com.cars24.csms.services.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserDetailsDaoImpl userDetailsDao;
    @Override
    public ResponseEntity<ApiResponse> signUpUser(SignupUserRequest signupUserRequest) {
        boolean res=userDetailsDao.existUser(signupUserRequest.getUsername());

        ApiResponse apiResponse=new ApiResponse();
        if(res) {


            throw new UserServiceException("User already exists");
        }
        else {
            apiResponse.setStatusCode(HttpStatus.OK.value());
            apiResponse.setSuccess(false);
            apiResponse.setMessage("User signup successfully");
            apiResponse.setData(null);
            apiResponse.setService("App user - "+HttpStatus.OK.value());
            userDetailsDao.createUser(signupUserRequest);
        }
        log.info("[signup]: {}", apiResponse);
        return ResponseEntity.ok().body(apiResponse);




    }

    @Override
    public boolean existUser(String username) {
        log.info("[Service existUser]: {}",username);
        return userDetailsDao.existUser(username);
    }
}
