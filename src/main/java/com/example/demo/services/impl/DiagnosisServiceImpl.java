package com.example.demo.services.impl;

import com.example.demo.models.Diagnosis;
import com.example.demo.repositories.DiagnosisRepository;
import com.example.demo.services.DiagnosisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class DiagnosisServiceImpl implements DiagnosisService {
    @Autowired
    private DiagnosisRepository diagnosisRepository;

    @Override
    public void add(Diagnosis diagnosis) {
        diagnosisRepository.save(diagnosis);
    }

    @Override
    public Diagnosis findById(Integer id) {
        return diagnosisRepository.findById(id).get();
    }
}
