package com.cars24.csms.data.req;

import com.cars24.csms.data.enums.AppointmentsStatus;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import lombok.Data;


@Valid
@Data
public class CreateAppointmentsRequest {
    @Valid
    @Min(value = 1, message = "Inavlid Customer ID")
    private int customerId;

    @Valid
    @Min(value = 1, message = "Invalid Vehice ID")
    private int vehicle_id;

    @Valid
    @Min(value = 1, message = "Invalid Service ID")
    private int service_id;

    @Valid
    private String appointmentDate;

// we do not need @Valid annotation here as enum does the work :)))
    private AppointmentsStatus status;

//    @Valid
//    private String status;
//    @Email     : does the mail validation
//    @NotBlank : no white spaces
//    private String email;

    @Override
    public String toString() {
        return "CreateAppointmentsRequest{" +
                "customerId=" + customerId +
                ", vehicle_id=" + vehicle_id +
                ", service_id=" + service_id +
                ", appointmentDate='" + appointmentDate + '\'' +
                ", status=" + status +
                '}';
    }
}
