package com.wizyta.server.dbHelpers;

import com.wizyta.server.apiHelpers.DoctorResponse;
import com.wizyta.server.conversion.DoctorResponseConversion;
import com.wizyta.server.jpa.DoctorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DoctorHelperImplementation implements DoctorHelper {

    private final DoctorRepository doctorRepository;
    private final DoctorResponseConversion doctorResponseConversion;

    @Override
    public List<DoctorResponse> getAllDoctors() {
        return doctorRepository.findAll().stream()
                .map(doctorResponseConversion::toResponse)
                .collect(Collectors.toList());
    }
}
