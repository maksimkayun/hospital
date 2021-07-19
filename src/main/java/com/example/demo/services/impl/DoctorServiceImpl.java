package com.example.demo.services.impl;

import com.example.demo.models.Doctor;
import com.example.demo.models.Patient;
import com.example.demo.repositories.DoctorRepository;
import com.example.demo.services.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class DoctorServiceImpl implements DoctorService {
    @Autowired
    private DoctorRepository doctorRepository;

    @Override
    public void hire(Doctor doctor) {
        doctorRepository.save(doctor);
    }

    @Override
    public Doctor findDoctor(int id) {
        return doctorRepository.findById(id).get();
    }
}
