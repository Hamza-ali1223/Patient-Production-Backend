package com.ps.patientservice.service;

import com.ps.patientservice.model.Patient;
import com.ps.patientservice.repository.PatientRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PatientService
{

    private final PatientRepository patientRepository;

    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public List<Patient> getAll()
    {
        return  patientRepository.findAll();
    }

    public Patient getById(UUID id)
    {
        return patientRepository.findById(id).orElse(null);
    }

    public Patient savePatient(Patient patient)
    {
        return patientRepository.save(patient);
    }

    public Boolean deleteById(UUID id)
    {
        if(patientRepository.existsById(id))
        {
            patientRepository.deleteById(id);
            return true;
        }
        return false;
    }





}
