package com.wizyta.server.dbHelpers;

import com.wizyta.server.apiHelpers.DoctorResponse;
import com.wizyta.server.conversion.DoctorResponseConversion;
import com.wizyta.server.data.Login;
import com.wizyta.server.jpa.DoctorRepository;
import com.wizyta.server.jpa.LoginRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class LoginHelperImplementation implements LoginHelper {

    private final LoginRepository loginRepository;
    private final DoctorResponseConversion doctorResponseConversion;

    @Override
    public Login getLogin(String login) {
        return loginRepository.findByLogin(login);
    }
    @Override
    public Login addLogin(Login login) {
        return loginRepository.save(login);
    }
}
