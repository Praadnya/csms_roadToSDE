package com.cars24.csms.data.req;

import jakarta.persistence.Entity;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import lombok.Data;

@Data
public class UpdateCustomerRequest {
    @Valid
    private String name;

    @Valid
    private String phone;

    @Valid
    @Email
    private String email;

    @Valid
    private String address;

    private boolean isActive;

}
