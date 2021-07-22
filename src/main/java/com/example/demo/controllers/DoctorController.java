package com.example.demo.controllers;

import com.example.demo.models.Doctor;
import com.example.demo.repositories.DoctorRepository;
import org.springframework.web.bind.annotation.*;

@RestController
public class DoctorController {
    private final DoctorRepository doctorRepository;

    public DoctorController(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    @GetMapping("/doctors")
    Iterable<Doctor> all() { return doctorRepository.findAll(); }
    @GetMapping("/doctors/{id}")
    Doctor one(@PathVariable Integer id) {
        return doctorRepository.findById(id).orElseThrow(()-> new DoctorNotFoundException(id));
    }
    @PostMapping("/doctors")
    Doctor newDoctor(@RequestBody Doctor newDoctor) { return doctorRepository.save(newDoctor); }
    @DeleteMapping("/doctors/{id}")
    void delete(@PathVariable Integer id) { doctorRepository.deleteById(id); }
}
