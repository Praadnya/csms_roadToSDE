package com.cars24.csms.data.dao;

import com.cars24.csms.data.entities.AppUserDetailsEntity;
import com.cars24.csms.data.req.LoginRequest;
import com.cars24.csms.data.req.SignUpReq;
import org.springframework.stereotype.Service;


@Service
public interface AppUserDao{
    AppUserDetailsEntity getAppUserDetails(LoginRequest loginRequest);
    AppUserDetailsEntity createUser(SignUpReq signUpReq);
    boolean isUserExists(String username);
}
