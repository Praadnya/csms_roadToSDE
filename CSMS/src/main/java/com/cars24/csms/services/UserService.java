package com.cars24.csms.services;

import com.cars24.csms.data.req.SignupUserRequest;
import com.cars24.csms.data.response.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    public ResponseEntity<ApiResponse> signUpUser(SignupUserRequest signupUserRequest);
    public boolean existUser(String username);

}