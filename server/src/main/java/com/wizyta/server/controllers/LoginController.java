package com.wizyta.server.controllers;

import com.wizyta.server.apiHelpers.AppointmentRequest;
import com.wizyta.server.apiHelpers.AppointmentResponse;
import com.wizyta.server.apiHelpers.LoginRequest;
import com.wizyta.server.apiHelpers.Msg;
import com.wizyta.server.dbHelpers.DoctorHelper;
import com.wizyta.server.dbHelpers.LoginHelper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/login")
@RequiredArgsConstructor
public class LoginController {
    private final LoginHelper loginHelper;
    @PostMapping
    Msg login(@RequestBody LoginRequest loginRequest){
        System.out.println(loginRequest.getLogin());
        var cokolwiek = loginHelper.getLogin(loginRequest.getLogin());
        if(cokolwiek==null){return new Msg("badusername");}
        if(cokolwiek.getPassword().equals(loginRequest.getPassword())){return new Msg("success");}
        return new Msg("badpassword");
    };

}
