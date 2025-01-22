package com.cars24.csms.controllers;

import com.cars24.csms.data.dao.UserDetailsDao;
import com.cars24.csms.data.dao.UserDetailsDaoImpl;
import com.cars24.csms.data.req.LoginUserRequest;
import com.cars24.csms.data.req.SignupUserRequest;
import com.cars24.csms.data.resp.ApiResponse;
import com.cars24.csms.services.impl.UserServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@Validated
@Slf4j
@RequestMapping("/users")
public class UserController {
    private final UserDetailsDaoImpl userDetailsDao;
    private final UserServiceImpl userService;
    @GetMapping("/login")
    public String getResponseFromUserDao(@Valid @RequestBody LoginUserRequest loginUserRequest)
    {
        log.info("[User controller]: {}", loginUserRequest);

        userDetailsDao.getUserDetails(loginUserRequest);
        log.info("[User controller]: {}", loginUserRequest);
        return "";
    }

    @PostMapping("/signup")
    public ResponseEntity<ApiResponse> signupUser(@Valid @RequestBody SignupUserRequest signupUserRequest)
    {

        log.info("[UserController for signup]: {}", signupUserRequest);
        return userService.signUpUser(signupUserRequest);

    }

}
