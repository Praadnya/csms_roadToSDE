package com.cars24.csms.data.dao.impl;

import com.cars24.csms.data.dao.AppointmentsServiceDao;
import com.cars24.csms.data.entities.AppointmentsEntity;
import com.cars24.csms.data.enums.AppointmentsStatus;
import com.cars24.csms.data.repositories.AppointmentsRepository;
import com.cars24.csms.data.req.CreateAppointmentsRequest;
import com.cars24.csms.data.response.GetAppointmentsResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class AppointmentsDaoImpl  implements AppointmentsServiceDao {

    private final AppointmentsRepository appointmentsRepository;

    @Override
    public int createAppointments(CreateAppointmentsRequest createAppointmentsRequest) {
        AppointmentsEntity appointmentsEntity=new AppointmentsEntity();

        appointmentsEntity.setCustomerId(createAppointmentsRequest.getCustomerId());
        appointmentsEntity.setVehicle_id(createAppointmentsRequest.getVehicle_id());
        appointmentsEntity.setService_id(createAppointmentsRequest.getService_id());
        appointmentsEntity.setAppointmentDate(createAppointmentsRequest.getAppointmentDate());
        appointmentsEntity.setStatus(createAppointmentsRequest.getStatus().toString());
//        Save : is the insert query
        appointmentsRepository.save(appointmentsEntity);
        return 0;
    }

    @Override
    public AppointmentsEntity getAppointments(Integer appointment_id) {
        AppointmentsEntity appointmentsEntity= appointmentsRepository.findById(appointment_id) .orElseThrow(()->new RuntimeException("Customer not found with id: "+appointment_id));
        GetAppointmentsResponse getAppointmentsResponse = new GetAppointmentsResponse();
        getAppointmentsResponse.setCustomer_id(appointmentsEntity.getCustomerId());
        getAppointmentsResponse.setVehicle_id(appointmentsEntity.getVehicle_id());
        getAppointmentsResponse.setService_id(appointmentsEntity.getService_id());
        getAppointmentsResponse.setAppointment_date(appointmentsEntity.getAppointmentDate());
        getAppointmentsResponse.setStatus(AppointmentsStatus.valueOf(appointmentsEntity.getStatus()));
        log.info("[getAppointment] in DAO, retrieved record: {}",getAppointmentsResponse);
        return appointmentsEntity;
    }


}
