package com.cars24.csms.services.impl;

import com.cars24.csms.data.dao.VehicleDao;
import com.cars24.csms.data.entities.VehicleEntity;
import com.cars24.csms.data.req.CreateVehicleReq;
import com.cars24.csms.data.res.CreateVehicleResponse;
import com.cars24.csms.services.VehicleServiceManagementService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class VehicleServiceManagementServiceImpl implements VehicleServiceManagementService {


    private final VehicleDao vehicleDao;
    @Override
    public CreateVehicleResponse createVehicle(CreateVehicleReq request) {
        VehicleEntity createdVehicle = vehicleDao.createVehicle(request);

        // Map VehicleEntity to CreateVehicleResponse
        CreateVehicleResponse response = new CreateVehicleResponse();

        response.setVehicle_id(createdVehicle.getVehicle_id());
        response.setCustomer_id(createdVehicle.getCustomer_id());
        response.setLicense_plate(createdVehicle.getLicense_plate());
        response.setModelName(createdVehicle.getModelName());
        response.setMake(createdVehicle.getMake());
        response.setYear(createdVehicle.getYear());
        response.setColor(createdVehicle.getColor());

        return response;
    }
}
