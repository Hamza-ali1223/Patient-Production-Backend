package com.ps.patientservice.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PatientDTO
{
    private String name;
    private String email;
    private String address;
    private String dateofBirth;
}
