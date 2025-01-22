package com.cars24.csms.data.Dao.Impl;

import com.cars24.csms.data.Dao.AppointmentDao;
import com.cars24.csms.data.entities.AppointmentsEntity;
import com.cars24.csms.data.repositories.AppointmentRepository;
import com.cars24.csms.data.req.CreateAppointmentRequest;
import com.cars24.csms.data.req.GetAppointmentRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class AppointmentDaoImpl implements AppointmentDao {

    private final AppointmentRepository appointmentRepository;
    @Override
    public int createAppointment(CreateAppointmentRequest createAppointmentRequest) {
        AppointmentsEntity appointmentsEntity = new AppointmentsEntity();
        appointmentsEntity.setCustomerId(createAppointmentRequest.getCustomer_id());
        appointmentsEntity.setStatus(createAppointmentRequest.getStatus().toString());
        appointmentsEntity.setVehicleId(createAppointmentRequest.getVehicle_id());
        appointmentsEntity.setAppointmentDate(createAppointmentRequest.getAppointment_date());
        appointmentsEntity.setServiceId(createAppointmentRequest.getService_id());
        appointmentRepository.save(appointmentsEntity);
        return 0;
    }
    @Override
    public List<AppointmentsEntity> getAppointment(GetAppointmentRequest getAppointmentRequest) {
        return appointmentRepository.findAllByStatus(getAppointmentRequest.getStatus());
    }
}