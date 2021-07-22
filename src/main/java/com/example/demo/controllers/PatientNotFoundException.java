package com.example.demo.controllers;

public class PatientNotFoundException extends RuntimeException {

    public PatientNotFoundException(Integer id) {
        super("Could not found patient id = " + id);
    }
}
