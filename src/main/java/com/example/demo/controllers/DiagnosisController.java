package com.example.demo.controllers;

import com.example.demo.models.Diagnosis;
import com.example.demo.repositories.DiagnosisRepository;
import org.springframework.web.bind.annotation.*;

@RestController
public class DiagnosisController {
    private final DiagnosisRepository diagnosisRepository;

    public DiagnosisController(DiagnosisRepository diagnosisRepository) {
        this.diagnosisRepository = diagnosisRepository;
    }

    @GetMapping("/diagnosis")
    Iterable<Diagnosis> all() { return diagnosisRepository.findAll(); }
    @GetMapping("/diagnosis/{id}")
    Diagnosis one(@PathVariable Integer id) {
        return diagnosisRepository.findById(id).orElseThrow(()->new DiagnosisNotFoundException(id));
    }
    @PostMapping("/diagnosis")
    Diagnosis newDiagnosis(@RequestBody Diagnosis newDiagnosis) { return diagnosisRepository.save(newDiagnosis); }
//    @DeleteMapping("/diagnosis/{id}")
//    void delete(@PathVariable Integer id) { diagnosisRepository.deleteById(id); }
}
