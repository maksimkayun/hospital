package com.example.demo.services;

import com.example.demo.models.Doctor;
import com.example.demo.models.Patient;

import java.util.List;

public interface DoctorService {
    void hire(Doctor doctor);
    Doctor findDoctor(int id);
}
