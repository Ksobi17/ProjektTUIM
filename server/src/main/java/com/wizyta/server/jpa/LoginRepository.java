package com.wizyta.server.jpa;

import com.wizyta.server.data.Doctor;
import com.wizyta.server.data.Login;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoginRepository extends JpaRepository<Login, Long> {
    Login findByLogin(String login);
}
