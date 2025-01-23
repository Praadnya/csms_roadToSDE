package com.cars24.csms.data.dao;


//whener
import com.cars24.csms.data.entities.CustomerEntity;
import com.cars24.csms.data.entities.UserDetailsEntity;
import com.cars24.csms.data.enums.UserType;
import com.cars24.csms.data.repositories.UserRepository;
import com.cars24.csms.data.req.LoginUserRequest;
import com.cars24.csms.data.req.SignupUserRequest;
import com.cars24.csms.data.resp.ApiResponse;
import com.cars24.csms.data.resp.LoginUserResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.User;
import org.springframework.stereotype.Service;

import javax.swing.text.html.parser.Entity;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserDetailsDaoImpl implements UserDetailsDao{
    private final UserRepository userRepository;

    @Override
    public String getUserDetails(LoginUserRequest loginUserRequest) {
//         LoginUserResponse loginUserResponse= new LoginUserResponse();
        UserDetailsEntity userDetailsEntity=userRepository.findUserDetailsByUsernameAndPassword(loginUserRequest.getUsername(),loginUserRequest.getPassword());
        log.info("[App user Details] :{}", userDetailsEntity);
        return "";
    }

    public boolean existUser(String username)
    {
//        ObjectMapper mapper=new ObjectMapper();
        boolean isExists=userRepository.existsByUsername(username);
//        UserDetailsEntity userDetailsEntity=mapper.convertValue(signupUserRequest, UserDetailsEntity.class);
//        userDetailsEntity.setActive(true);
//        userRepository.save(userDetailsEntity);
        log.info("[User exists or not]: {}",username);
        return isExists;

    }

    @Override
    public String createUser(SignupUserRequest signupUserRequest) {
        log.info("[createUser] IN DAO");
        ObjectMapper objectMapper = new ObjectMapper();
        UserDetailsEntity userDetailsEntity = objectMapper.convertValue(signupUserRequest, UserDetailsEntity.class);
        userDetailsEntity.setActive(true);
//        userDetailsEntity.setUserType(UserType.CUSTOMER);

        userRepository.save(userDetailsEntity);

        return "";
    }

    public int getUserId(String username)
    {
        UserDetailsEntity userDetailsEntity=userRepository.findByUsername(username);
        int userId=userDetailsEntity.getUser_id();
        log.info("[get userId] in Dao: {}",userId);
        return userId;

    }
}
