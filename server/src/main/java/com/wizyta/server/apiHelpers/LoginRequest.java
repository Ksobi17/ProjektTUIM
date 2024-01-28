package com.wizyta.server.apiHelpers;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginRequest {
    String login;
    String password;
}
