package com.example.demo.controllers;

import com.example.demo.models.Patient;
import com.example.demo.repositories.PatientRepository;
import org.springframework.web.bind.annotation.*;

@RestController
public class PatientController {
    private final PatientRepository patientRepository;

    public PatientController(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @GetMapping("/patients")
    Iterable<Patient> all() { return patientRepository.findAll(); }

    @PostMapping("/patients")
    Patient newPatient(@RequestBody Patient newPatient) { return patientRepository.save(newPatient); }

    @GetMapping("/patients/{id}")
    Patient one(@PathVariable Integer id) {
        return patientRepository.findById(id).orElseThrow(()-> new PatientNotFoundException(id));
    }

    @DeleteMapping("/patients/{id}")
    void delete(@PathVariable Integer id) {
        patientRepository.deleteById(id);
    }
}
