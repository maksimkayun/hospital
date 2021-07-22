package com.example.demo.controllers;

import com.example.demo.models.Patient;
import com.example.demo.repositories.DoctorRepository;
import com.example.demo.repositories.PatientRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PatientController {
    private final PatientRepository patientRepository;
    private final DoctorRepository doctorRepository;

    public PatientController(PatientRepository patientRepository, DoctorRepository doctorRepository) {
        this.patientRepository = patientRepository;
        this.doctorRepository = doctorRepository;
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

    @GetMapping("patients/bydoctor/{id}")
    List<Patient> findByDoctor(@PathVariable Integer id) {
        return patientRepository.findByDoctor(doctorRepository.findById(id).get());
    }

    @GetMapping("patients/bydoctor/current/{id}")
    List<Patient> findByDoctorCurrent(@PathVariable Integer id) {
        return patientRepository.findByDoctorAndDischargeDateIsNull(doctorRepository.findById(id).get());
    }

    @GetMapping("patients/bydoctor/discharged/{id}")
    List<Patient> findByDoctorDischarged(@PathVariable Integer id) {
        return patientRepository.findByDoctorAndDischargeDateNotNull(doctorRepository.findById(id).get());
    }
}
