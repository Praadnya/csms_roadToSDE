package com.cars24.csms.services.impl;

import com.cars24.csms.data.dao.AppUserDao;
import com.cars24.csms.data.entities.AppUserDetails;
import com.cars24.csms.data.repositories.AppUserDetailsRepository;
import com.cars24.csms.data.req.SignUpReq;
import com.cars24.csms.data.res.ApiResponse;
import com.cars24.csms.exceptions.UserServiceException;
import com.cars24.csms.services.AppUserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AppUserServiceImpl implements AppUserService {

    private final AppUserDao appUserDao;



    @Override
    public ResponseEntity<ApiResponse> registerUser(SignUpReq signUpReq) {


        ApiResponse apiResponse = new ApiResponse();

        if(appUserDao.isExists(signUpReq.getUsername())) {
            throw new UserServiceException("User Already Exists");

        }else{
            //function to insert into the database
            AppUserDetails appUserDetails = appUserDao.createUser(signUpReq);

            apiResponse.setStatusCode(HttpStatus.OK.value());
            apiResponse.setSuccess(true);
            apiResponse.setMessage("User registered successfully");
            apiResponse.setService("APPUSR"+ HttpStatus.OK.value());
            apiResponse.setData(null);
        }
        return ResponseEntity.ok().body(apiResponse);

    }
}
