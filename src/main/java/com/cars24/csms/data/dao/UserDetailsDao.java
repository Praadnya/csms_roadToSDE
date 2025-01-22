package com.cars24.csms.data.dao;

import com.cars24.csms.data.req.LoginUserRequest;
import com.cars24.csms.data.req.SignupUserRequest;

public interface UserDetailsDao {
    String getUserDetails(LoginUserRequest loginUserRequest);
    boolean existUser(String username);
    String createUser(SignupUserRequest signupUserRequest);

}
