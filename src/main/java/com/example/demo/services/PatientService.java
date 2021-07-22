package com.example.demo.services;

import com.example.demo.models.Diagnosis;
import com.example.demo.models.Doctor;
import com.example.demo.models.Patient;

import java.util.List;

public interface PatientService {

    void register(Patient patient);

    void discharge(Patient patient);

    void setDiagnosis(Patient patient, Diagnosis diagnosis);

    void discharge(int id);

    Patient findPatient(int id);

    List<Patient> findByDoctor(Doctor doctor);

    List<Patient> findByDiagnosis(Diagnosis diagnosis);

    List<Patient> findByDoctorCurrent(Doctor doctor);

    List<Patient> findByDoctorDischarged(Doctor doctor);
}

