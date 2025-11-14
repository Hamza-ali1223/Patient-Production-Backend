package com.ps.patientservice.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@Data
@NoArgsConstructor
@Entity
public class Patient
{
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @NotNull
    private String name;
    @NotNull
    @Email
    @Column(unique = true)
    private String email;
    @NotBlank
    private String address;
    @NotNull
    private LocalDate dateofBirth;
    @NotNull
    private LocalDate registeredDate;

}
