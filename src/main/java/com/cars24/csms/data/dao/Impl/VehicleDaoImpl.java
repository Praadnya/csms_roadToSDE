package com.cars24.csms.data.dao.Impl;

import com.cars24.csms.advice.ResourceNotFoundException;
import com.cars24.csms.data.dao.VehicleDao;
import com.cars24.csms.data.entities.VehicleEntity;
import com.cars24.csms.data.repositories.VehiclesRepository;
import com.cars24.csms.data.req.CreateVehicleReq;
import lombok.RequiredArgsConstructor;
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

    @Override
    public VehicleEntity getVehicle(Integer vehicleId) {
        return repo.findById(vehicleId)
                .orElseThrow(() -> new ResourceNotFoundException("Vehicle not found for ID: " + vehicleId));

    }








//    @Override
//    public void deleteVehicleById(Integer vehicleId) {
//        if(!repo.existsById(vehicleId)) {
//            throw new ResourceNotFoundException("Vehicle not Found for ID: "+ vehicleId);
//        }
//        repo.deleteById(vehicleId);
//    }


}
