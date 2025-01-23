package com.cars24.csms.data.repositories;

import com.cars24.csms.data.entities.VehicleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VehiclesRepository extends JpaRepository<VehicleEntity,Integer> {
    List<VehicleEntity> findByCustomerIdAndDeletedFalse(Integer customerId);
    boolean existsByLicensePlate(String licensePlate);
    VehicleEntity findByLicensePlate(String licensePlate);
}
