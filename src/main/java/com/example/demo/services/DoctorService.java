package com.example.demo.services;

import com.example.demo.models.Doctor;

public interface DoctorService {
    void hire(Doctor doctor);
    Doctor findDoctor(int id);
}
