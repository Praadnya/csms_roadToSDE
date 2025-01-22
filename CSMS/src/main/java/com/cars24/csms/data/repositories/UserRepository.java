package com.cars24.csms.data.repositories;

import com.cars24.csms.data.entities.UserDetailsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserDetailsEntity,Integer> {
    UserDetailsEntity findUserDetailsByUsernameAndPassword(String username, String password);
    boolean existsByUsername(String username);
}