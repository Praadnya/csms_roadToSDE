package com.cars24.csms.data.entities;

import jakarta.persistence.Column;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.lang.NonNull;

import javax.persistence.*;

@jakarta.persistence.Table(name = "customers")
@jakarta.persistence.Entity
public class CustomerEntity {
    @Setter
    @Getter
    @jakarta.persistence.Id
    @Column(name="customer_id",nullable = false)
    private int custId;
    @Setter
    @Getter
    @jakarta.persistence.Column(nullable = false)
    @Length(min = 3,max = 100, message = "invalid")
    private String name;
    @Setter
    @Getter
    @jakarta.persistence.Column(unique = true,nullable = false)
    private String phone;
    @Getter
    @Setter
    @jakarta.persistence.Column(unique = true,nullable = false)
    private String email;
    @Setter
    @Getter
    @jakarta.persistence.Column(nullable = false)
    private String address;
    @Column(name="isActive",nullable=false)
    private boolean isActive;


    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}
