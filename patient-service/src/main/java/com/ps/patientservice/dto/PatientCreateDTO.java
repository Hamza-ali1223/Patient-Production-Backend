package com.ps.patientservice.dto;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PatientCreateDTO
{
    @NotBlank(message = "Name should not be Empty")
    private String name;

    @NotNull
    @Email(message = "Provide a correct Email")
    private String email;

    @NotBlank(message = "Empty Address not Allowed")
    private String address;

    @NotNull(message = "Empty Birth Date not Allowed")
    private LocalDate dateofBirth;

    @NotNull(groups = PatientUpdateGroup.class, message = "Registered Date Should'nt be empty")
    private LocalDate registeredDate;

}
