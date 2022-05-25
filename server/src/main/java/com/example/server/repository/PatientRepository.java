package com.example.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.server.model.Patient;

public interface PatientRepository extends JpaRepository<Patient, Long>{

}
