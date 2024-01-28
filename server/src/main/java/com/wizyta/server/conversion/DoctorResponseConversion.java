package com.wizyta.server.conversion;

import com.wizyta.server.data.Doctor;
import com.wizyta.server.apiHelpers.DoctorResponse;
import org.springframework.stereotype.Component;

@Component
public class DoctorResponseConversion {
    public DoctorResponse toResponse(Doctor doctor){
        return new DoctorResponse(
                doctor.getId(),
                doctor.getName()
        );
    }
}
