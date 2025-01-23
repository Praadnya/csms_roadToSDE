package com.cars24.csms.data.dao.Impl;

import com.cars24.csms.data.dao.AppUserDao;
import com.cars24.csms.data.entities.AppUserDetailsEntity;
import com.cars24.csms.data.repositories.AppUserDetailsRepository;
import com.cars24.csms.data.req.LoginRequest;
import com.cars24.csms.data.req.SignUpReq;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


@Slf4j
@Service
@RequiredArgsConstructor
public class AppUserDaoImpl implements AppUserDao {

    private final AppUserDetailsRepository appUserDetailsRepository;
    @Override
    public AppUserDetailsEntity getAppUserDetails(LoginRequest loginRequest) {
        AppUserDetailsEntity appUserDetailsEntity = appUserDetailsRepository.findAppUserDetailsByUsernameAndPassword(loginRequest.getUsername(), loginRequest.getPassword());
        log.info("[getAppUserDetails] AppUserDetails: {}", appUserDetailsEntity);

        return appUserDetailsEntity;
    }

    public boolean isUserExists(String username){
        return appUserDetailsRepository.existsByUsername(username);
    }

    public AppUserDetailsEntity createUser(SignUpReq signUpReq) {

        ObjectMapper mapper = new ObjectMapper();
        AppUserDetailsEntity entity = mapper.convertValue(signUpReq, AppUserDetailsEntity.class);        //converts the values of signup into app user entity
        entity.setEnabled(Boolean.TRUE);

        return appUserDetailsRepository.save(entity);

    }
}
