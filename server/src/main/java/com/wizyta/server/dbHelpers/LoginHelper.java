package com.wizyta.server.dbHelpers;

import com.wizyta.server.apiHelpers.DoctorResponse;
import com.wizyta.server.data.Login;

import java.util.List;

public interface LoginHelper {

    Login getLogin(String login);
    Login addLogin(Login login);
}
