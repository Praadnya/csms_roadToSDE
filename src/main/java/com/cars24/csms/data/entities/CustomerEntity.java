package com.cars24.csms.data.entities;

import jakarta.persistence.Column;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.springframework.lang.NonNull;

import javax.persistence.*;

@jakarta.persistence.Table(name = "customers")
@jakarta.persistence.Entity
public class CustomerEntity {
    @jakarta.persistence.Id
    @Column(name="customer_id",nullable = false)
    private int custId;
    @jakarta.persistence.Column(nullable = false)
    @Length(min = 3,max = 100, message = "invalid")
    private String name;
    @jakarta.persistence.Column(unique = true,nullable = false)
    private String phone;
    @jakarta.persistence.Column(unique = true,nullable = false)
    private String email;
    @jakarta.persistence.Column(nullable = false)
    private String address;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getCustId() {
        return custId;
    }

    public void setCustId(int custId) {
        this.custId = custId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }



}
