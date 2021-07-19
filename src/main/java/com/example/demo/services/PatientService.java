package com.example.demo.services;

import com.example.demo.models.Doctor;
import com.example.demo.models.Patient;

import java.util.List;

public interface PatientService {

    void register(Patient patient);

    void discharge(Patient patient);

    void setDiagnosis(Patient patient, String diagnosis);

    void discharge(int id);

    Patient findPatient(int id);

    List<Patient> findByDoctor(Doctor doctor);
}

