package com.example.demo.init;

import com.example.demo.models.Diagnosis;
import com.example.demo.models.Doctor;
import com.example.demo.models.Patient;
import com.example.demo.services.DiagnosisService;
import com.example.demo.services.DoctorService;
import com.example.demo.services.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ConsoleRunner implements CommandLineRunner {
    @Autowired
    private PatientService patientService;
    @Autowired
    private DoctorService doctorService;
    @Autowired
    private DiagnosisService diagnosisService;

    @Override
    public void run(String... args) throws Exception {
        Doctor d_1 = new Doctor("Michael");
        Doctor d_2 = new Doctor("Rudolf");

        // нанимаем докторов
        doctorService.hire(d_1);
        doctorService.hire(d_2);

        // Регистрируем пациентов к первому доктору
        patientService.register(new Patient("Maksim", d_1));
        patientService.register(new Patient("Nikolay", d_1));

        // Регистрируем пациентов ко второму доктору
        patientService.register(new Patient("Vasily", d_2));
        patientService.register(new Patient("Ivan", d_2));
        patientService.register(new Patient("Vlad", d_2));

        // Пополняем коллекцию диагнозов
        diagnosisService.add(new Diagnosis("Nonspecific ulcerative colitis"));
        diagnosisService.add(new Diagnosis("RSI"));

        // Выясняем диагнозы и регистрируем их у первых двух пациентов
        patientService.setDiagnosis(patientService.findPatient(1),diagnosisService.findById(1));
        patientService.setDiagnosis(patientService.findPatient(2),diagnosisService.findById(2));
        patientService.setDiagnosis(patientService.findPatient(3),diagnosisService.findById(2));

        // Выписываем их
        patientService.discharge(1);
        patientService.discharge(2);

        for (Patient patient: patientService.findByDoctor(d_1)) {
            System.out.println(patient.toString());
        }

        for (Patient patient: patientService.findByDiagnosis(diagnosisService.findById(2))) {
            System.out.println(patient.toString());
        }

        for (Patient patient: patientService.findByDoctorAndDischargeDateIsNull(d_1)) {
            System.out.println(patient.toString());
        }

        for (Patient patient: patientService.findByDoctorAndDischargeDateIsNull(d_2)) {
            System.out.println(patient.toString());
        }
    }
}
