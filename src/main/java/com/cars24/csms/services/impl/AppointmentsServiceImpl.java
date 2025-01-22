package com.cars24.csms.services.impl;

import com.cars24.csms.data.dao.impl.AppointmentsDaoImpl;
import com.cars24.csms.data.entities.AppointmentsEntity;
import com.cars24.csms.data.req.CreateAppointmentsRequest;
import com.cars24.csms.data.response.CreateAppointmentsResponse;
import com.cars24.csms.services.AppointmentsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class AppointmentsServiceImpl implements AppointmentsService {

    final private AppointmentsDaoImpl appointmentsDao;
    @Override
    public CreateAppointmentsResponse createAppointmentsResponse(CreateAppointmentsRequest createAppointmentsRequest) {
        appointmentsDao.createAppointments(createAppointmentsRequest);
        return null;
    }

    @Override
    public AppointmentsEntity getAppointments(Integer appointment_id) {

        AppointmentsEntity response = appointmentsDao.getAppointments(appointment_id);
        log.info("[GetCustomerService]CustomerService{}",appointment_id);
        return response;
    }
}
