package com.wizyta.server.controllers;

import com.wizyta.server.dbHelpers.DoctorHelper;
import com.wizyta.server.apiHelpers.DoctorResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/doctor")
@RequiredArgsConstructor
public class DoctorController {

    private final DoctorHelper doctorHelper;

    @GetMapping
    List<DoctorResponse> getAllDoctors() {
        return doctorHelper.getAllDoctors();
    }
}
