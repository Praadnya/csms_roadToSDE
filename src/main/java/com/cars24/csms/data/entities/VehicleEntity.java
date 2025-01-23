package com.cars24.csms.data.entities;


import jakarta.persistence.*;
import lombok.Data;

@Table(name ="vehicles")
@Entity
@Data
public class VehicleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vehicle_id")
    private int vehicleId;

    @Column(name = "customer_id")
    private int customerId;


    @Column(name ="license_plate")
    private String licensePlate;

    @Column(name = "model")
    private String modelName;

    @Column(name = "make")
    private String make;

    @Column(name = "year")
    private int year;

    @Column(name = "color")
    private String color;

    @Column(name ="deleted")
    private boolean deleted;
}
