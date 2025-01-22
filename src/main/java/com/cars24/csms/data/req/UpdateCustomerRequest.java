package com.cars24.csms.data.req;

import jakarta.validation.Valid;
import lombok.Data;

@Data
public class UpdateCustomerRequest {
    @Valid
    private String name;

    @Valid
    private String phone;

    @Valid
    private String email;

    @Valid
    private String address;

    private boolean isActive;

}
