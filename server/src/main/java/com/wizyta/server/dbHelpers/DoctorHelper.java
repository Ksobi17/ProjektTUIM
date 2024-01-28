package com.wizyta.server.dbHelpers;

import com.wizyta.server.apiHelpers.DoctorResponse;

import java.util.List;

public interface DoctorHelper {

    List<DoctorResponse> getAllDoctors();
}
