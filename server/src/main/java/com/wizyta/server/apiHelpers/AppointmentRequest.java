package com.wizyta.server.apiHelpers;

import lombok.Data;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Data
public class AppointmentRequest {
    private long doctorId;
    private String name;
    private LocalDateTime date;
}
