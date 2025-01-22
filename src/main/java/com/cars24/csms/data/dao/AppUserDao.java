package com.cars24.csms.data.dao;

import com.cars24.csms.data.entities.AppUserDetails;
import com.cars24.csms.data.req.LoginRequest;
import org.springframework.stereotype.Service;


@Service
public interface AppUserDao{
    AppUserDetails getAppUserDetails(LoginRequest loginRequest);
}
