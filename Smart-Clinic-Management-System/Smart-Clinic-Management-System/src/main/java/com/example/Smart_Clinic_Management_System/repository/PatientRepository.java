package com.example.Smart_Clinic_Management_System.repository;

import com.example.Smart_Clinic_Management_System.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PatientRepository extends JpaRepository<Patient, Long> {
    Optional<Patient> findByEmail(String email);
}
