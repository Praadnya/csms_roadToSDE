package com.cars24.csms.data.repositories;

import com.cars24.csms.data.entities.ServiceEntity;
import com.cars24.csms.data.entities.VehicleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ServiceRepository extends JpaRepository<ServiceEntity,Integer> {
    List<VehicleEntity> findByModel(String model);
    List<VehicleEntity> findByColor(String color);
    List<VehicleEntity> findByModelAndColor(String model, String color);
    VehicleEntity findByLicensePlate(String licensePlate);
}