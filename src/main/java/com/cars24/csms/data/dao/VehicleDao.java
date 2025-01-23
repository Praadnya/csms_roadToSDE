package com.cars24.csms.data.dao;

import com.cars24.csms.data.entities.VehicleEntity;
import com.cars24.csms.data.req.CreateVehicleReq;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface VehicleDao {
    VehicleEntity createVehicle(CreateVehicleReq createVehicleReq);
    boolean isCustomerExists(Integer customerId);
    List<VehicleEntity> getAllVehicles(Integer customerId);
    boolean isVehicleExists(String vehicleId);
    void deleteVehicle(String licensePlate);
    boolean existsByLicensePlate(String licensePlate);

//    void deleteVehicleById(Integer vehicleId);

}
