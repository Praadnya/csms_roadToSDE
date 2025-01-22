package com.cars24.csms.services;

import com.cars24.csms.data.req.CreateVehicleReq;
import com.cars24.csms.data.res.CreateVehicleResponse;
import com.cars24.csms.data.res.GetVehicleRes;
import org.springframework.stereotype.Service;


@Service
public interface VehicleServiceManagementService {
    CreateVehicleResponse createVehicle(CreateVehicleReq request);
    GetVehicleRes getVehicle(Integer vehicle_id);
//    void deleteVehicle(Integer vehicle_id);


}
