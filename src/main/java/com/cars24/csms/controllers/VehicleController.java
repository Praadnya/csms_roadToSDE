package com.cars24.csms.controllers;


import com.cars24.csms.data.req.CreateVehicleReq;
import com.cars24.csms.data.res.ApiResponse;
import com.cars24.csms.services.VehicleServiceManagementService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/vehicle")
@Validated
@Slf4j
@RequiredArgsConstructor
@Service
public class VehicleController {

    private final VehicleServiceManagementService vehicleServiceManagementService;

    @PostMapping("/create")
    public ResponseEntity<ApiResponse> createVehicle(@Valid @RequestBody CreateVehicleReq createVehicleReq) {
        log.info("[createVehicle] createVehicleReq: {}", createVehicleReq);

        ApiResponse response = vehicleServiceManagementService.createVehicle(createVehicleReq);

        return ResponseEntity.ok().body(response);
    }


    @GetMapping("/fetch/{customerId}")
    public ResponseEntity<ApiResponse> getVehicleDetails(@PathVariable Integer customerId) {

        //this should call a method in service layer that returns GetVehicleRes object
        //it should process the passed parameter
        ApiResponse apiResponse = vehicleServiceManagementService.getVehicles(customerId);
        return ResponseEntity.ok().body(apiResponse);
    }

    @DeleteMapping("/delete/{licensePlate}")
    public ResponseEntity<ApiResponse> deleteVehicle(@PathVariable String licensePlate) {
        ApiResponse apiResponse= vehicleServiceManagementService.deleteVehicle(licensePlate);
        return ResponseEntity.ok().body(apiResponse);
    }

}
