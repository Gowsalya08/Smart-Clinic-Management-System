package com.example.Smart_Clinic_Management_System.service;

import com.example.Smart_Clinic_Management_System.model.Doctor;
import com.example.Smart_Clinic_Management_System.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    public Doctor registerDoctor(Doctor doctor) {
        return doctorRepository.save(doctor);
    }

    public List<Doctor> getAllDoctors() {
        return doctorRepository.findAll();
    }

    public Optional<Doctor> getDoctorById(Long id) {
        return doctorRepository.findById(id);
    }

    public Optional<Doctor> login(String email, String password) {
        Optional<Doctor> doctor = doctorRepository.findByEmail(email);
        if (doctor.isPresent() && doctor.get().getPassword().equals(password)) {
            return doctor;
        }
        return Optional.empty();
    }
}
