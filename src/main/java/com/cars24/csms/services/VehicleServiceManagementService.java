package com.cars24.csms.services;

import com.cars24.csms.data.req.CreateVehicleReq;
import com.cars24.csms.data.res.CreateVehicleResponse;
import org.springframework.stereotype.Service;


@Service
public interface VehicleServiceManagementService {
    CreateVehicleResponse createVehicle(CreateVehicleReq request);


}
