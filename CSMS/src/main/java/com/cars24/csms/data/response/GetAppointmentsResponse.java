package com.cars24.csms.data.response;

import com.cars24.csms.data.enums.AppointmentsStatus;
import jakarta.validation.Valid;
import lombok.Data;

@Data
@Valid
public class GetAppointmentsResponse {

//    @Valid
//    private int appointment_id;
    private int customer_id;
    private int vehicle_id;
    private int service_id;
    private String appointment_date;
    private AppointmentsStatus status;
}
