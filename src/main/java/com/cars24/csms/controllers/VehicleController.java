package com.cars24.csms.controllers;


import com.cars24.csms.data.req.CreateVehicleReq;
import com.cars24.csms.data.res.CreateVehicleResponse;
import com.cars24.csms.services.VehicleServiceManagementService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/vehicle")
@Validated
@Slf4j
@RequiredArgsConstructor
@Service
public class VehicleController {

    private final VehicleServiceManagementService vehicleServiceManagementService;

    @PostMapping("/create")
    public ResponseEntity<CreateVehicleResponse> createVehicle(@Valid @RequestBody CreateVehicleReq createVehicleReq) {
        log.info("[createVehicle] createVehicleReq: {}", createVehicleReq);
//        System.out.println("[createVehicle] createVehicleReq: {}"+ createVehicleReq);

        CreateVehicleResponse response = vehicleServiceManagementService.createVehicle(createVehicleReq);


        return ResponseEntity.ok().body(response);
    }

}
