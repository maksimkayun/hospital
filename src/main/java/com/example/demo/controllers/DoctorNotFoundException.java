package com.example.demo.controllers;

public class DoctorNotFoundException extends RuntimeException {

    public DoctorNotFoundException(Integer id) {
        super("Could not found doctor id = " + id);
    }
}
