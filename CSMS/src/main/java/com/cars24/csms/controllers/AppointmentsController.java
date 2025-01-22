package com.cars24.csms.controllers;

import com.cars24.csms.data.entities.AppointmentsEntity;
import com.cars24.csms.data.req.CreateAppointmentsRequest;
import com.cars24.csms.data.req.GetAppointmentsRequest;
import com.cars24.csms.data.response.CreateAppointmentsResponse;
import com.cars24.csms.data.response.GetAppointmentsResponse;
import com.cars24.csms.services.impl.AppointmentsServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/appointments")
@Validated
@Slf4j
@Service
@Valid
public class AppointmentsController {

    private final AppointmentsServiceImpl appointmentsService;

    @GetMapping("/profile/{appointment_id}")
    public ResponseEntity<AppointmentsEntity> getAppointments(@Valid @PathVariable Integer appointment_id)
    {
        GetAppointmentsResponse getAppointmentsResponse = new GetAppointmentsResponse();
        log.info("[In get controller] getAppointmentsRequest{}",appointment_id);
        AppointmentsEntity appointmentsEntity = appointmentsService.getAppointments(appointment_id);
        return ResponseEntity.ok().body(appointmentsEntity);
    }


    @PostMapping("/addAppointments")
    public ResponseEntity<CreateAppointmentsResponse> createAppointment(@Valid @RequestBody CreateAppointmentsRequest createAppointmentsRequest){
        log.info("[createAppointments] createAppointmentsRequest {}", createAppointmentsRequest);
        CreateAppointmentsResponse createAppointmentsResponse = new CreateAppointmentsResponse();
//        from here....
        CreateAppointmentsResponse response = new CreateAppointmentsResponse();
        response.setCustomerId(createAppointmentsRequest.getCustomerId());
        response.setVehicle_id(createAppointmentsRequest.getVehicle_id());
        response.setService_id(createAppointmentsRequest.getService_id());
        response.setAppointmentDate(createAppointmentsRequest.getAppointmentDate());
        response.setStatus(createAppointmentsRequest.getStatus());
//        return response;
//        ....till here can be removed; this is only used to also check on the postman what values have we entered, else the other way of writing shows the default values in the postman
        appointmentsService.createAppointmentsResponse(createAppointmentsRequest);
//        return ResponseEntity.ok().body(createAppointmentsResponse);
        return ResponseEntity.ok().body(response);
    }





}
