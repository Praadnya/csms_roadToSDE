package com.cars24.csms.data.dao.impl;

import com.cars24.csms.data.dao.UserDetailsDao;
import com.cars24.csms.data.entities.UserDetailsEntity;
import com.cars24.csms.data.repositories.UserRepository;
import com.cars24.csms.data.req.LoginUserRequest;
import com.cars24.csms.data.req.SignupUserRequest;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserDetailsDaoImpl implements UserDetailsDao {

    private final UserRepository userRepository;

    @Override
    public String getUserDetails(LoginUserRequest loginUserRequest) {
        UserDetailsEntity userDetailsEntity = userRepository.findUserDetailsByUsernameAndPassword(loginUserRequest.getUsername(),loginUserRequest.getPassword());
        log.info("[App user Details] :{}", userDetailsEntity);
        return "";
    }

    @Override
    public boolean existUser(String username) {
        boolean isExists=userRepository.existsByUsername(username);
        log.info("[User exists or not]: {}",username);
        return isExists;
    }

    @Override
    public String createUser(SignupUserRequest signupUserRequest) {
        log.info("[createUser] IN DAO");
        ObjectMapper objectMapper = new ObjectMapper();
        UserDetailsEntity userDetailsEntity = objectMapper.convertValue(signupUserRequest, UserDetailsEntity.class);
        userDetailsEntity.setActive(true);

        userRepository.save(userDetailsEntity);
        return "";
    }
}
