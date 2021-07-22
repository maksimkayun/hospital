package com.example.demo.services.impl;

import com.example.demo.models.Diagnosis;
import com.example.demo.models.Doctor;
import com.example.demo.models.Patient;
import com.example.demo.repositories.PatientRepository;
import com.example.demo.services.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Transactional
@Service
public class PatientServiceImpl implements PatientService {

    @Autowired
    private PatientRepository patientRepository;

    @Override
    public void register(Patient patient) {
        patientRepository.save(patient);
    }

    @Override
    public void discharge(Patient patient) {
        patientRepository.findById(patient.getId()).get().setDischargeDate(new Date());
    }

    //...
    @Override
    public void setDiagnosis(Patient patient, Diagnosis diagnosis) {
        patientRepository.findById(patient.getId()).get().setDiagnosis(diagnosis);
    }

    @Override
    public void discharge(int id) {
        patientRepository.findById(id).get().setDischargeDate(new Date());
    }

    @Override
    public Patient findPatient(int id) {
        return patientRepository.findById(id).get();
    }
    //...
    @Override
    public List<Patient> findByDoctor(Doctor doctor) {
        return patientRepository.findByDoctor(doctor);
    }

    @Override
    public List<Patient> findByDiagnosis(Diagnosis diagnosis) {
        return patientRepository.findByDiagnosis(diagnosis);
    }

    @Override
    public List<Patient> findByDoctorCurrent(Doctor doctor) {
        return patientRepository.findByDoctorAndDischargeDateIsNull(doctor);
    }

    @Override
    public List<Patient> findByDoctorDischarged(Doctor doctor) {
        return patientRepository.findByDoctorAndDischargeDateNotNull(doctor);
    }
}

