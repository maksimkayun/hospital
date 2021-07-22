package com.example.demo.repositories;

import com.example.demo.models.Diagnosis;
import com.example.demo.models.Doctor;
import com.example.demo.models.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PatientRepository extends CrudRepository<Patient, Integer> {
    List<Patient> findByDoctor(Doctor doctor);
    List<Patient> findByDiagnosis(Diagnosis diagnosis);
    List<Patient> findByDoctorAndDischargeDateIsNull(Doctor doctor);
    List<Patient> findByDoctorAndDischargeDateNotNull(Doctor doctor);
}

