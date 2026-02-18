package com.example.Smart_Clinic_Management_System.controller;

import com.example.Smart_Clinic_Management_System.model.Prescription;
import com.example.Smart_Clinic_Management_System.service.PrescriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/prescriptions")
@CrossOrigin(origins = "*")
public class PrescriptionController {

    @Autowired
    private PrescriptionService prescriptionService;

    @PostMapping
    public Prescription createPrescription(@RequestBody Prescription prescription) {
        return prescriptionService.createPrescription(prescription);
    }

    @GetMapping("/appointment/{appointmentId}")
    public List<Prescription> getPrescriptionsByAppointment(@PathVariable Long appointmentId) {
        return prescriptionService.getPrescriptionsByAppointment(appointmentId);
    }
}
