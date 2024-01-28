package com.wizyta.server.conversion;

import com.wizyta.server.data.Appointment;
import com.wizyta.server.data.Doctor;
import com.wizyta.server.apiHelpers.AppointmentRequest;
import com.wizyta.server.dbHelpers.DoctorHelper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RequestAppointmentConversion {

    private final DoctorHelper doctorHelper;

    public Appointment mapToAppointment(AppointmentRequest request){
        Appointment appointment = new Appointment();
        appointment.setName(request.getName());
        appointment.setDate(request.getDate());
        appointment.setDoctor(new Doctor(request.getDoctorId(), null));
        return appointment;
    }
}
