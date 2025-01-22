package com.cars24.csms.Services.Impl;

import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import com.cars24.csms.data.Dao.Impl.AppointmentDaoImpl;
import com.cars24.csms.data.repositories.AppointmentRepository;
import com.cars24.csms.data.repositories.CustomerRepository;
import com.cars24.csms.data.res.ApiResponse;
import com.cars24.csms.Exceptions.UserServiceException;
import org.springframework.http.HttpStatus;
import com.cars24.csms.data.repositories.ServiceRepository;
import com.cars24.csms.data.repositories.VehicleRepository;
import com.cars24.csms.data.req.CreateAppointmentRequest;
import com.cars24.csms.data.entities.AppointmentsEntity;
import com.cars24.csms.data.req.GetAppointmentRequest;
import com.cars24.csms.Services.AppointmentService;

import java.util.List;

@RequiredArgsConstructor
@Service
public class AppointmentServiceImpl implements AppointmentService {
    final private AppointmentDaoImpl appointmentDao;
    final private AppointmentRepository appointmentRepository;
    final private VehicleRepository vehicleRepository;
    final private CustomerRepository customerRepository;

    public List<AppointmentsEntity> getAppointment(GetAppointmentRequest getAppointmentRequest){
        return appointmentDao.getAppointment(getAppointmentRequest);
    }

    final private ServiceRepository serviceRepository;
    @Override
    public ResponseEntity<ApiResponse> CreateAppointmentResponse(CreateAppointmentRequest createAppointmentRequest) {
        if(!customerRepository.existsById(createAppointmentRequest.getCustomer_id())){
            throw new UserServiceException("No Record present of given Customer Id");
        }
        if(!serviceRepository.existsById(createAppointmentRequest.getService_id())){
            throw new UserServiceException("No Record present of given Customer Id");
        }
        if(!vehicleRepository.existsById(createAppointmentRequest.getVehicle_id())){
            throw new UserServiceException("No Record present of given Customer Id");
        }
        if(appointmentRepository.existsByCSVId(
                createAppointmentRequest.getService_id(),
                createAppointmentRequest.getVehicle_id(),
                createAppointmentRequest.getCustomer_id())
        ) { throw new UserServiceException("U cannot have redundant ID's for multiple rows"); }

        appointmentDao.createAppointment(createAppointmentRequest);
        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setMessage("Added Successfully!!");
        apiResponse.setStatusCode(HttpStatus.OK.value());
        apiResponse.setData(null);
        apiResponse.setSuccess(true);
        apiResponse.setService("APP_USER = "+ HttpStatus.OK.value());
        return ResponseEntity.ok().body(apiResponse);
    }
}
