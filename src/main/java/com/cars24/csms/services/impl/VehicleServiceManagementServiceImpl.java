package com.cars24.csms.services.impl;

import com.cars24.csms.data.dao.VehicleDao;
import com.cars24.csms.data.entities.VehicleEntity;
import com.cars24.csms.data.req.CreateVehicleReq;
import com.cars24.csms.data.res.ApiResponse;
import com.cars24.csms.exceptions.ResourceNotFoundException;
import com.cars24.csms.services.VehicleServiceManagementService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class VehicleServiceManagementServiceImpl implements VehicleServiceManagementService {


    private final VehicleDao vehicleDao;

    @Override
    public ApiResponse createVehicle(CreateVehicleReq request) {

        if(!vehicleDao.isCustomerExists(request.getCustomer_id())){
            throw new ResourceNotFoundException("Customer with ID " + request.getCustomer_id() + " does not exist.");
        }
        else if(vehicleDao.isVehicleExists(request.getLicense_plate())){
            throw new ResourceNotFoundException("License plate " + request.getLicense_plate() + " already exist.");
        }
        VehicleEntity createdVehicle = vehicleDao.createVehicle(request);

        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setStatusCode(HttpStatus.OK.value());
        apiResponse.setSuccess(true);
        apiResponse.setMessage("Vehicle created successfully.");
        apiResponse.setService("APPVEH"+ HttpStatus.OK.value());
        apiResponse.setData(createdVehicle);

        return apiResponse;
    }


    //to be done after creation
    public ApiResponse getVehicles(Integer customerId) {

        //this should call a method in dao where the function should return either entity or a response itself
        if(!vehicleDao.isCustomerExists(customerId)){
            throw new ResourceNotFoundException("Customer with ID " + customerId + " does not exist.");
        }
        List<VehicleEntity> vehicleEntityList =vehicleDao.getAllVehicles(customerId);

        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setStatusCode(HttpStatus.OK.value());
        apiResponse.setSuccess(true);
        apiResponse.setMessage("Vehicles fetched successfully.");
        apiResponse.setService("APPVEH"+ HttpStatus.OK.value());
        apiResponse.setData(vehicleEntityList);

        return apiResponse;
    }

    public ApiResponse deleteVehicle(String licensePlate) {
        if(!vehicleDao.existsByLicensePlate(licensePlate)){
            throw new ResourceNotFoundException("License plate " + licensePlate + " does not exist.");
        }
        vehicleDao.deleteVehicle(licensePlate);
        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setStatusCode(HttpStatus.OK.value());
        apiResponse.setSuccess(true);
        apiResponse.setMessage("Vehicle deleted successfully.");
        apiResponse.setService("APPVEH"+ HttpStatus.OK.value());
        apiResponse.setData(null);
        return apiResponse;
    }

//    public void deleteVehicle(Integer vehicle_id) {
//        vehicleDao.deleteVehicleById(vehicle_id);
//    }
}
