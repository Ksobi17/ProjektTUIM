package com.wizyta.server.conversion;

import com.wizyta.server.data.Appointment;
import com.wizyta.server.apiHelpers.AppointmentResponse;
import org.springframework.stereotype.Component;

@Component
public class AppointmentResponseConversion {

    public AppointmentResponse toResponse(Appointment appointment){
        return new AppointmentResponse(
                appointment.getId(),
                appointment.getDoctor().getName(),
                appointment.getName(),
                appointment.getDate()
        );
    }
}
