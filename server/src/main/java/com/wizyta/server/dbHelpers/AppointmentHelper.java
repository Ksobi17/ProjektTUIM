package com.wizyta.server.dbHelpers;

import com.wizyta.server.apiHelpers.AppointmentRequest;
import com.wizyta.server.apiHelpers.AppointmentResponse;
import com.wizyta.server.data.Appointment;

import java.util.List;

public interface AppointmentHelper {
    List<AppointmentResponse> getAllAppointment();
    Appointment addAppointment(AppointmentRequest appointmentRequest);
}
