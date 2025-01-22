package com.cars24.csms.data.response;

import com.cars24.csms.data.enums.AppointmentsStatus;
import jakarta.validation.Valid;
import lombok.Data;

@Valid
@Data
public class CreateAppointmentsResponse {

    private int customerId;
    private int vehicle_id;
    private int service_id;
    private String appointmentDate;
    private AppointmentsStatus status;

//    public int getCustomerId() {
//        return customerId;
//    }
//
//    public void setCustomerId(int customerId) {
//        this.customerId = customerId;
//    }
//
//    public int getVehicle_id() {
//        return vehicle_id;
//    }
//
//    public void setVehicle_id(int vehicle_id) {
//        this.vehicle_id = vehicle_id;
//    }
//
//    public int getService_id() {
//        return service_id;
//    }
//
//    public void setService_id(int service_id) {
//        this.service_id = service_id;
//    }
//
//    public String getAppointmentDate() {
//        return appointmentDate;
//    }
//
//    public void setAppointmentDate(String appointmentDate) {
//        this.appointmentDate = appointmentDate;
//    }
//
//    public AppointmentsStatus getStatus() {
//        return status;
//    }
//
//    public void setStatus(AppointmentsStatus status) {
//        this.status = status;
//    }
}
