package com.example.server.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.server.exception.ResourceNotFoundException;
import com.example.server.model.Patient;
import com.example.server.repository.PatientRepository;

@CrossOrigin
@RestController
@RequestMapping("/api/v1")
public class PatientController {

	@Autowired
	private PatientRepository patientRepository;
	
	//get all patients
	@GetMapping("/patients")
	public List<Patient> getAllPatient(){
		return patientRepository.findAll();
	}
	//create patient rest employee
	@PostMapping("/patients")
	public Patient createPatient(@RequestBody Patient patient) {
		return patientRepository.save(patient);
	}
	
	//get patient by id rest api
	@GetMapping("/patients/{id}")
	public ResponseEntity<Patient> getPatientById(@PathVariable Long id){
		Patient patient = patientRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Patient not exixts with id : "+id));
		return ResponseEntity.ok(patient);
	}
}
