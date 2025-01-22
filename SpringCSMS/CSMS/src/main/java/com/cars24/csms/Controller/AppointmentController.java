package com.cars24.csms.Controller;

import com.cars24.csms.Services.Impl.AppointmentServiceImpl;
import com.cars24.csms.data.entities.AppointmentsEntity;
import com.cars24.csms.data.req.CreateAppointmentRequest;
import com.cars24.csms.data.req.GetAppointmentRequest;
import com.cars24.csms.data.res.ApiResponse;
import com.cars24.csms.data.res.CreateAppointmentResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@Slf4j
@Valid
@Service
@RestController
@RequiredArgsConstructor
@RequestMapping("/appointments")
public class AppointmentController {
    private final AppointmentServiceImpl appointmentServiceImpl;
    @PostMapping("/create")
    public ResponseEntity<ApiResponse> createAppointment(@Valid @RequestBody CreateAppointmentRequest createAppointmentRequest){
        log.info("[createAppointment] createAppointmentRequest {}", createAppointmentRequest);
        CreateAppointmentResponse createAppointmentResponse = new CreateAppointmentResponse();
        return appointmentServiceImpl.CreateAppointmentResponse(createAppointmentRequest);
    }

    @GetMapping("/retrieve")
    public ResponseEntity<List<AppointmentsEntity>> getAppointment(@Valid @RequestBody GetAppointmentRequest getAppointmentRequest){
        log.info("[getAppointment] createAppointmentRequest {}", getAppointmentRequest);
        return ResponseEntity.ok().body(appointmentServiceImpl.getAppointment(getAppointmentRequest));
    }
}