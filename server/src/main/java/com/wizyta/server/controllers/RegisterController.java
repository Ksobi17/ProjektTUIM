package com.wizyta.server.controllers;

import com.wizyta.server.apiHelpers.*;
import com.wizyta.server.data.Login;
import com.wizyta.server.dbHelpers.LoginHelper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/register")
@RequiredArgsConstructor
public class RegisterController {

    private final LoginHelper loginHelper;

    @PostMapping
    public Msg register(@RequestBody RegisterRequest registerRequest) {
        var cokolwiek = loginHelper.getLogin(registerRequest.getLogin());
        if(cokolwiek!=null){return new Msg("takenusername");}
        if(registerRequest.getLogin()==null||registerRequest.getLogin().equals("")){return new Msg("badusername");}
        if(registerRequest.getPassword()==null||registerRequest.getPassword().equals("")){return new Msg("badpassword");}
        Login login = new Login();
        login.setLogin(registerRequest.getLogin());
        login.setPassword(registerRequest.getPassword());
        if(loginHelper.addLogin(login)!=null){return new Msg("success");}
        return new Msg("badpassword");
    }
}
