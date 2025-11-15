package com.ps.patientservice.repository;

import com.ps.patientservice.model.Patient;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PatientRepository extends JpaRepository<Patient, UUID>
{
    public Boolean existsPatientByEmail(String email);


}
