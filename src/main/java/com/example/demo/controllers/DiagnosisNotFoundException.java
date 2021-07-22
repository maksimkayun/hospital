package com.example.demo.controllers;

public class DiagnosisNotFoundException extends RuntimeException {
    public DiagnosisNotFoundException(Integer id) {
        super("Could not found diagnosis id = " + id);
    }
}
