package com.cars24.csms.data.req;

import jakarta.validation.Valid;
import lombok.Data;

@Data
@Valid
public class GetAppointmentsRequest {
    @Valid
    private int appointment_id;
}
