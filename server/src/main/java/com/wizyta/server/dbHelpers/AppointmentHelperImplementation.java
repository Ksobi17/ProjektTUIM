package com.wizyta.server.dbHelpers;

import com.wizyta.server.apiHelpers.AppointmentRequest;
import com.wizyta.server.apiHelpers.AppointmentResponse;
import com.wizyta.server.data.Appointment;
import com.wizyta.server.conversion.AppointmentResponseConversion;
import com.wizyta.server.conversion.RequestAppointmentConversion;
import com.wizyta.server.jpa.AppointmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AppointmentHelperImplementation implements AppointmentHelper {

    private final AppointmentRepository appointmentRepository;
    private final AppointmentResponseConversion appointmentResponseConversion;
    private final RequestAppointmentConversion requestAppointmentConversion;

    public List<AppointmentResponse> getAllAppointment() {
    return appointmentRepository.findAll().stream()
            .map(appointmentResponseConversion::toResponse)
            .collect(Collectors.toList());
    }

    @Override
    public Appointment addAppointment(AppointmentRequest appointmentRequest) {
        return appointmentRepository.save(requestAppointmentConversion.mapToAppointment(appointmentRequest));
    }
}
