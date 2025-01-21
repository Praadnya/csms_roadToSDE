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
    private String name;
   //checks for white spaces and null values
    @Valid
    @Pattern(regexp = "^[6-9]\\d{9}$") @NotBlank
    private String phone;
    @Valid
    @Email
    @NotBlank
    @Length @NotNull
    private String email;
    @Valid
    @NotBlank


    private String address;




}
