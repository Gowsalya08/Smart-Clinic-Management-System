package com.example.Smart_Clinic_Management_System.repository;

import com.example.Smart_Clinic_Management_System.model.Prescription;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PrescriptionRepository extends JpaRepository<Prescription, Long> {
    List<Prescription> findByAppointmentId(Long appointmentId);
}
