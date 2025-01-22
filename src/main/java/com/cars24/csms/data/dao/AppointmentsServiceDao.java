package com.cars24.csms.data.dao;

import com.cars24.csms.data.entities.AppointmentsEntity;
import com.cars24.csms.data.req.CreateAppointmentsRequest;
import com.cars24.csms.data.response.GetAppointmentsResponse;
import org.springframework.stereotype.Service;

@Service
public interface AppointmentsServiceDao {
    int createAppointments(CreateAppointmentsRequest createAppointmentsRequest);
    AppointmentsEntity getAppointments(int appointment_id);
}
