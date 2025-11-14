package com.ps.patientservice.controller;

import com.ps.patientservice.dto.PatientCreateDTO;
import com.ps.patientservice.dto.PatientDTO;
import com.ps.patientservice.mapper.PatientMapper;
import com.ps.patientservice.model.Patient;
import com.ps.patientservice.service.PatientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/patients")
public class PatientController
{
    private final PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping
    public ResponseEntity<List<PatientDTO>> getAllPatients()
    {
        //It gets All patient list, converts to Response DTO and returns them
        return ResponseEntity.ok(patientService.getAll().stream().map(PatientMapper::toDTO).toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PatientDTO> getPatientById(@PathVariable String id)
    {
        UUID uuid = UUID.fromString(id);
        return ResponseEntity.ok(PatientMapper.toDTO(patientService.getById(uuid)));
    }

    @PostMapping
    public ResponseEntity<Patient> savePatient(@RequestBody PatientCreateDTO patient)
    {
        return ResponseEntity.status(HttpStatus.CREATED).body(patientService.savePatient(PatientMapper.fromDTO(patient)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable String id)
    {
        UUID uuid = UUID.fromString(id);
        if(patientService.deleteById(uuid))
        {
            return ResponseEntity.status(HttpStatus.OK).body("Success: Deleted Patient of ID: "+uuid.toString());
        }
        return ResponseEntity.badRequest().build();

    }

}
