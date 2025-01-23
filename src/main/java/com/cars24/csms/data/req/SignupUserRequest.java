package com.cars24.csms.data.req;

import com.cars24.csms.data.enums.UserType;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data

public class SignupUserRequest {
    @Valid
    @Email
    @Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$",message = "Email is invalid!")
    @NotBlank(message = "username should not be empty" )
    private String username;

    @Valid @NotBlank(message = "password should not be empty")
    @Size(min=8, max = 20, message = "Password must be 8 to 20 characters only!")
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$", message = "Password should contain uppercase,lowercase,digit,special character!!")
    private String password;

    private UserType user_type;

}
