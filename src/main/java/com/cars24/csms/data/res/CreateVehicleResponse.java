package com.cars24.csms.data.res;
import lombok.Data;
import org.springframework.validation.annotation.Validated;

@Data
public class CreateVehicleResponse {

    private int vehicle_id;

    private int customer_id;

    private String license_plate;

    private String modelName;

    private String make;

    private int year;

    private String color;
}
