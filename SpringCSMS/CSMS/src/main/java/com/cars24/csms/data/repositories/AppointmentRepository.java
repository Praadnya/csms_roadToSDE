package com.cars24.csms.data.repositories;

import com.cars24.csms.data.entities.AppointmentsEntity;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.*;

@Repository
public interface AppointmentRepository extends JpaRepository<AppointmentsEntity, Integer> {
    boolean existsByCSVId(
            @Valid @Min(value = 1, message = "service ID Not Valid") int serviceId,
            @Valid @Min(value = 1, message = "vehicle ID Not Valid") int vehicleId,
            @Valid @Min(value = 1, message = "customer ID Not Valid") int customerId);
    List<AppointmentsEntity> findAllByStatus(String status);
}
