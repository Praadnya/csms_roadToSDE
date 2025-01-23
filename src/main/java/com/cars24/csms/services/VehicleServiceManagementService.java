package com.cars24.csms.services;

import com.cars24.csms.data.req.CreateVehicleReq;
import com.cars24.csms.data.res.ApiResponse;
import org.springframework.stereotype.Service;


@Service
public interface VehicleServiceManagementService {
    ApiResponse createVehicle(CreateVehicleReq request);
    ApiResponse getVehicles(Integer vehicle_id);
    ApiResponse deleteVehicle(String licensePlate);


}
