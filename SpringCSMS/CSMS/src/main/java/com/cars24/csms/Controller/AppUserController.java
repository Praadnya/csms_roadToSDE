package com.cars24.csms.Controller;

import com.cars24.csms.Services.Impl.AppUserServiceImpl;
import com.cars24.csms.data.req.LoginRequest;
import com.cars24.csms.data.req.SignupRequest;
import com.cars24.csms.data.res.ApiResponse;
import com.cars24.csms.data.res.LoginResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;


@Slf4j
@Service
@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class AppUserController {
    private final AppUserServiceImpl appUserService;
    @GetMapping("/login")
    public ResponseEntity<LoginResponse> getAppUser(@Valid @RequestBody LoginRequest loginRequest){
        LoginResponse loginResponse = appUserService.getAppUserDetails(loginRequest);
        return ResponseEntity.ok().body(loginResponse);
    }

    @PostMapping("/signup")
    public ResponseEntity<ApiResponse> createAppUser(@Valid @RequestBody SignupRequest signupRequest){
        log.info("sign_up");
        return appUserService.signUp(signupRequest);
    }
}