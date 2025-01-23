package com.cars24.csms.data.req;

import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;


//entry point for the application



@Data

public class CreateCustomerRequest {
    @Valid
    private int custId;
    @Valid @Size(min=3, max=45, message = "Name should be in between 3 to 45 characters only!") @NotBlank

    private String name;
   //checks for white spaces and null values
    @Valid
    @Pattern(regexp = "^[6-9]\\d{9}$",message = "Phone number should be 10 digits only!") @NotBlank
    private String phone;
    @Valid
    @Email
    @NotBlank
    @Length @NotNull
    private String email;
    @Valid
    @NotBlank
    private String address;


//    @Valid
//    @NotBlank
    private boolean isActive;




}
