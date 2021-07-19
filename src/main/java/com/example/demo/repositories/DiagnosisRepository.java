package com.example.demo.repositories;

import com.example.demo.models.Diagnosis;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiagnosisRepository extends CrudRepository<Diagnosis, Integer> {
}
