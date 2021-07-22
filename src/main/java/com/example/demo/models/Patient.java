package com.example.demo.models;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "patients")
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "name", length = 50, nullable = false)
    private String name;
    @Column(name = "registration_date")
    private Date registrationDate = new Date();
    @Column(name = "discharge_date", nullable = true)
    private Date dischargeDate;

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    @ManyToOne
    private Doctor doctor;


    public void setDiagnosis(Diagnosis diagnosis) {
        this.diagnosis = diagnosis;
    }

    //...
    @ManyToOne
    private Diagnosis diagnosis;

    public void setDischargeDate(Date dischargeDate) {
        this.dischargeDate = dischargeDate;
    }
    //...


    public Patient(String name, Doctor doctor) {
        this.name = name;
        this.doctor = doctor;
    }

    public Patient() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", registrationDate=" + registrationDate +
                ", dischargeDate=" + dischargeDate +
                ", diagnosis=" + diagnosis +
                '}';
    }

    public Date getDischargeDate() {
        return dischargeDate;
    }



}
