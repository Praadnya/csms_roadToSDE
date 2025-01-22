package com.cars24.csms.data.entities;

//import javax.persistence.*;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Table(name = "appointments")
@Entity
public class AppointmentsEntity {
    @Id
    @Column(name = "appointment_id")
    private int appointmentId;
//    @NonNull
    @Column(name = "customer_id", nullable = false)
    private int customerId;

    @Column(name = "vehicle_id",nullable = false)
    private int vehicle_id;

    @Column(name = "service_id", nullable = false)
    private int service_id;

    @Column(name = "appointment_date", nullable = false)
    private String appointmentDate;

    @Column(name = "status", nullable = false, length = 50)
    private String status;
}
