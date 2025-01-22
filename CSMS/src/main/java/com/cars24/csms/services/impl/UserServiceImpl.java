package com.cars24.csms.services.impl;

import com.cars24.csms.data.dao.impl.UserDetailsDaoImpl;
import com.cars24.csms.data.req.SignupUserRequest;
import com.cars24.csms.data.response.ApiResponse;
import com.cars24.csms.exceptions.UserServiceException;
import com.cars24.csms.services.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserDetailsDaoImpl userDetailsDao;

    @Override
    public ResponseEntity<ApiResponse> signUpUser(SignupUserRequest signupUserRequest) {
        boolean response = userDetailsDao.existUser(signupUserRequest.getUsername());

        ApiResponse apiResponse = new ApiResponse();
        if(response) {
            throw new UserServiceException("User already exists");
        }
        else {
            apiResponse.setStatusCode(HttpStatus.OK.value());
            apiResponse.setSuccess(false);
            apiResponse.setMessage("User signup successfully");
            apiResponse.setData(null);
            apiResponse.setService("APPUSER - "+HttpStatus.OK.value());
            userDetailsDao.createUser(signupUserRequest);
        }
        log.info("[signup]: {}", apiResponse);
        return ResponseEntity.ok().body(apiResponse);
    }


    @Override
    public boolean existUser(String username) {
        return false;
    }
}
