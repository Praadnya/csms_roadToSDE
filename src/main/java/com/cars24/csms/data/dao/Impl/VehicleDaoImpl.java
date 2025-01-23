package com.cars24.csms.data.dao.Impl;

import com.cars24.csms.data.repositories.CustomerRepository;
import com.cars24.csms.data.dao.VehicleDao;
import com.cars24.csms.data.entities.VehicleEntity;
import com.cars24.csms.data.repositories.VehiclesRepository;
import com.cars24.csms.data.req.CreateVehicleReq;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class VehicleDaoImpl implements VehicleDao {

    private final VehiclesRepository repo;
    private final CustomerRepository userRepo;



    @Override
    public boolean isCustomerExists(Integer customerId){
        return userRepo.existsById(customerId);
    }

    public boolean isVehicleExists(String vehicleId){
        return repo.existsByLicensePlate(vehicleId);
    }

    @Override
    public List<VehicleEntity> getAllVehicles(Integer customerId) {
        return repo.findByCustomerIdAndDeletedFalse(customerId);
    }

    @Override
    public VehicleEntity createVehicle(CreateVehicleReq createVehicleReq) {

        VehicleEntity vehicle = new VehicleEntity();
        vehicle.setCustomerId(createVehicleReq.getCustomer_id());
        vehicle.setLicensePlate(createVehicleReq.getLicense_plate());
        vehicle.setModelName(createVehicleReq.getModelName());
        vehicle.setMake(createVehicleReq.getMake());
        vehicle.setYear(createVehicleReq.getYear());
        vehicle.setColor(createVehicleReq.getColor());


        return repo.save(vehicle);
    }

    public boolean existsByLicensePlate(String licensePlate) {
        return repo.existsByLicensePlate(licensePlate);
    }

    public void deleteVehicle(String licensePlate) {
        VehicleEntity vehicle=repo.findByLicensePlate(licensePlate);
        vehicle.setDeleted(true);
        repo.save(vehicle);

    }




}
