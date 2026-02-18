package com.example.Smart_Clinic_Management_System.repository;

import com.example.Smart_Clinic_Management_System.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
    Optional<Doctor> findByEmail(String email);
}
