package com.cars24.csms.services;

import com.cars24.csms.data.entities.AppointmentsEntity;
import com.cars24.csms.data.req.CreateAppointmentsRequest;
import com.cars24.csms.data.response.CreateAppointmentsResponse;
import org.springframework.stereotype.Service;

@Service
public interface AppointmentsService {
    public CreateAppointmentsResponse createAppointmentsResponse(CreateAppointmentsRequest createAppointmentsRequest);
    AppointmentsEntity getAppointments(Integer appointment_id);
}
