package com.example.demo.services;

import com.example.demo.models.Diagnosis;

public interface DiagnosisService {
    void add(Diagnosis diagnosis);
    Diagnosis findById(Integer id);
}
