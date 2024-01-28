package com.wizyta.server.controllers;

import com.wizyta.server.dbHelpers.AppointmentHelper;
import com.wizyta.server.apiHelpers.AppointmentRequest;
import com.wizyta.server.apiHelpers.AppointmentResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/appointment")
public class AppointmentController {

    private final AppointmentHelper appointmentHelper;

    @GetMapping
    public List<AppointmentResponse> getAllAppointment(){
        return appointmentHelper.getAllAppointment();
    }

    @PostMapping
    public List<AppointmentResponse> addNewAppointment(@RequestBody AppointmentRequest appointmentRequest) {

        var appointment = appointmentHelper.addAppointment(appointmentRequest);
//        ArrayList<AppointmentResponse> appointmentlist = appointmentService.getAllAppointment();
        return appointmentHelper.getAllAppointment();
    }
}
