package com.cars24.csms.data.entities;

import com.cars24.csms.data.enums.UserType;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Generated;
import org.springframework.boot.autoconfigure.web.WebProperties;

@Table(name="UserDetailsEntity")
@Data
@Entity
public class UserDetailsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="user_id", nullable = false)
    private int user_id;

    @Column(name="username", nullable = false)
    private String username;

    @Column(name="password", nullable = false)
    private String password;

    @Column(name="isActive", nullable = false)
    private boolean isActive;

    @Column(name="user_type",nullable = false)
    private String user_type;

    @OneToOne(mappedBy = "userDetailsEntity")
    private CustomerEntity customerEntity;


}
