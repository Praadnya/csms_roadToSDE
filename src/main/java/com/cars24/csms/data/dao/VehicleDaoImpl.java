package com.cars24.csms.data.dao;

import com.cars24.csms.data.entities.VehicleEntity;
import com.cars24.csms.data.repositories.VehiclesRepository;
import com.cars24.csms.data.req.CreateVehicleReq;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class VehicleDaoImpl implements VehicleDao {

    private final VehiclesRepository repo;
    @Override
    public VehicleEntity createVehicle(CreateVehicleReq createVehicleReq) {

        VehicleEntity vehicle = new VehicleEntity();
        vehicle.setCustomer_id(createVehicleReq.getCustomer_id());
        vehicle.setLicense_plate(createVehicleReq.getLicense_plate());
        vehicle.setModelName(createVehicleReq.getModelName());
        vehicle.setMake(createVehicleReq.getMake());
        vehicle.setYear(createVehicleReq.getYear());
        vehicle.setColor(createVehicleReq.getColor());


        return repo.save(vehicle);
    }
}
