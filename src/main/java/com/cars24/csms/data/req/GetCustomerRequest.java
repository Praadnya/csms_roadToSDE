package com.cars24.csms.data.req;

import jakarta.validation.Valid;
import lombok.Data;

@Data
public class GetCustomerRequest {
    @Valid
    private int custId;

}
