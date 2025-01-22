package com.cars24.csms.data.dao.Impl;

import com.cars24.csms.data.dao.AppUserDao;
import com.cars24.csms.data.entities.AppUserDetails;
import com.cars24.csms.data.repositories.AppUserDetailsRepository;
import com.cars24.csms.data.req.LoginRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


@Slf4j
@Service
@RequiredArgsConstructor
public class AppUserDaoImpl implements AppUserDao {

    private final AppUserDetailsRepository appUserDetailsRepository;
    @Override
    public AppUserDetails getAppUserDetails(LoginRequest loginRequest) {
        AppUserDetails appUserDetails = appUserDetailsRepository.findAppUserDetailsByUsernameAndPassword(loginRequest.getUsername(), loginRequest.getPassword());
        log.info("[getAppUserDetails] AppUserDetails: {}", appUserDetails);

        return appUserDetails;
    }
}
