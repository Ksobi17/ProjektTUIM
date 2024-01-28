package com.wizyta.server.jpa;

import com.wizyta.server.data.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
}
