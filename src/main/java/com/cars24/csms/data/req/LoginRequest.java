package com.cars24.csms.data.req;


import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;

import lombok.Data;

@Data
@Valid
public class LoginRequest {


    @Valid
    @NotBlank
    private String username;

    @Valid
    @NotBlank
    private String password;

}
