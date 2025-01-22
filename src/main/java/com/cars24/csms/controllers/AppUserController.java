package com.cars24.csms.controllers;


import com.cars24.csms.data.dao.Impl.AppUserDaoImpl;
import com.cars24.csms.data.entities.AppUserDetails;
import com.cars24.csms.data.req.LoginRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/User")
@RequiredArgsConstructor
@Validated
@Service
public class AppUserController {
    private final AppUserDaoImpl appUserDao;

    @GetMapping("/login")
    public ResponseEntity<AppUserDetails> createAppUser(@Valid @RequestParam("username") String username , @RequestParam("password") String password) {
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setUsername(username);
        loginRequest.setPassword(password);
        AppUserDetails appUserDetails = appUserDao.getAppUserDetails(loginRequest);

        return ResponseEntity.ok().body(appUserDetails);
    }
}
