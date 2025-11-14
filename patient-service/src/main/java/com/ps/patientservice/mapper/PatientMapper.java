package com.ps.patientservice.mapper;

import com.ps.patientservice.dto.PatientCreateDTO;
import com.ps.patientservice.dto.PatientDTO;
import com.ps.patientservice.model.Patient;

import java.util.UUID;

public class PatientMapper
{
    private PatientMapper()
    {
        throw  new IllegalStateException("Utility Class: PatientMapper shouldn't be instantiated");
    }
    /**
     * Converts a {@link Patient} entity into its corresponding {@link PatientDTO}.
     * <p>
     * This method maps the domain-level {@code Patient} model into a transport-level
     * DTO that is safe to expose through REST APIs. All relevant fields are copied
     * from the entity to the DTO, and any necessary formatting (such as converting
     * {@link java.time.LocalDate} to {@code String}) is handled here.
     * </p>
     *
     * <h3>💡 Recommended Usage</h3>
     * <p>
     * This method is designed to be used when converting collections of {@code Patient}
     * entities retrieved from the database. Instead of writing a verbose lambda such as:
     * </p>
     *
     * <pre>{@code
     * patients.stream()
     *         .map(p -> PatientMapper.toDTO(p))
     *         .toList();
     * }</pre>
     *
     * <p>
     * You can use Java's method reference syntax for cleaner and more idiomatic code:
     * </p>
     *
     * <pre>{@code
     * patients.stream()
     *         .map(PatientMapper::toDTO)
     *         .toList();
     * }</pre>
     *
     * <p>
     * Using method references improves readability, reduces noise, and follows standard
     * Java functional style conventions.
     * </p>
     *
     * @param p the {@code Patient} entity to convert; must not be {@code null}
     * @return a fully populated {@code PatientDTO} representing the provided entity
     */
    public static final PatientDTO toDTO(Patient p)
    {
        return PatientDTO.builder()
                .name(p.getName())
                .email(p.getEmail())
                .dateofBirth(p.getDateofBirth().toString())
                .address(p.getAddress())
                .build();
    }

    public static final Patient fromDTO(PatientCreateDTO dto) {
    Patient patient = new Patient();
   patient.setRegisteredDate(dto.getRegisteredDate());
    patient.setName(dto.getName());
    patient.setEmail(dto.getEmail());
    patient.setDateofBirth(dto.getDateofBirth());
    patient.setAddress(dto.getAddress());
    return patient;
    }
}
