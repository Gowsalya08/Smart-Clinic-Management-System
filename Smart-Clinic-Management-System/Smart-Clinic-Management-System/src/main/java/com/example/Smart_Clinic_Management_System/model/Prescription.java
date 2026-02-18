package com.example.Smart_Clinic_Management_System.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Prescription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "appointment_id", referencedColumnName = "id")
    private Appointment appointment;

    @NotBlank(message = "Medication is required")
    private String medication;

    @NotBlank(message = "Dosage is required")
    private String dosage;

    @NotBlank(message = "Instructions are required")
    private String instructions;
}
