package com.cars24.csms.controllers;


import com.cars24.csms.data.dao.Impl.AppUserDaoImpl;
import com.cars24.csms.data.entities.AppUserDetailsEntity;
import com.cars24.csms.data.req.LoginRequest;
import com.cars24.csms.data.req.SignUpReq;
import com.cars24.csms.data.res.ApiResponse;
import com.cars24.csms.services.impl.AppUserServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Users")
@RequiredArgsConstructor
@Validated
@Service
@Slf4j
public class AppUserController {
    private final AppUserDaoImpl appUserDao;
    private final AppUserServiceImpl appUserService;

    @GetMapping("/login")
    public ResponseEntity<AppUserDetailsEntity> getAppUser(@Valid @RequestParam("username") String username , @RequestParam("password") String password) {
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setUsername(username);
        loginRequest.setPassword(password);
        AppUserDetailsEntity appUserDetailsEntity = appUserDao.getAppUserDetails(loginRequest);

        return ResponseEntity.ok().body(appUserDetailsEntity);
    }

    @PostMapping("/signup")
    public ResponseEntity<ApiResponse> signUp(@Valid @RequestBody SignUpReq signUpReq) {

        log.info("[signUp] signUpReq: {}", signUpReq);
        return appUserService.registerUser(signUpReq);

    }
}
