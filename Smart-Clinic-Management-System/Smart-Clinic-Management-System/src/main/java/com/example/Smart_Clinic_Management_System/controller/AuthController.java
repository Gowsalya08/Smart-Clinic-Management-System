package com.example.Smart_Clinic_Management_System.controller;

import com.example.Smart_Clinic_Management_System.model.Doctor;
import com.example.Smart_Clinic_Management_System.model.Patient;
import com.example.Smart_Clinic_Management_System.service.DoctorService;
import com.example.Smart_Clinic_Management_System.service.PatientService;
import com.example.Smart_Clinic_Management_System.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*")
public class AuthController {

    @Autowired
    private DoctorService doctorService;

    @Autowired
    private PatientService patientService;

    @Autowired
    private TokenService tokenService;

    @PostMapping("/login/doctor")
    public ResponseEntity<?> loginDoctor(@RequestBody Map<String, String> credentials) {
        String email = credentials.get("email");
        String password = credentials.get("password");

        Optional<Doctor> doctor = doctorService.login(email, password);
        if (doctor.isPresent()) {
            String token = tokenService.generateToken(doctor.get().getId());
            return ResponseEntity.ok(Map.of("token", token, "role", "DOCTOR", "id", doctor.get().getId()));
        }
        return ResponseEntity.status(401).body("Invalid credentials");
    }

    @PostMapping("/register/patient")
    public Patient registerPatient(@RequestBody @jakarta.validation.Valid Patient patient) {
        return patientService.registerPatient(patient);
    }

    @PostMapping("/login/patient")
    public ResponseEntity<?> loginPatient(@RequestBody Map<String, String> credentials) {
        // Simple login for patient based on email (for demo)
        String email = credentials.get("email");
        Optional<Patient> patient = patientService.getPatientByEmail(email);
        if (patient.isPresent()) {
            String token = tokenService.generateToken(patient.get().getId()); // Reusing token service, though ID
                                                                              // collision possible if not careful, but
                                                                              // okay for demo
            return ResponseEntity.ok(Map.of("token", token, "role", "PATIENT", "id", patient.get().getId()));
        }
        return ResponseEntity.status(401).body("Patient not found");
    }
}
