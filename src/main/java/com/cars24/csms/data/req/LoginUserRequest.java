package com.cars24.csms.data.req;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
@Data
public class LoginUserRequest {
    @Valid @NotBlank(message = "Username canot be blank")
    private String username;
    @Valid @NotBlank(message = "Password cannot be blank")
    private String password;
}
