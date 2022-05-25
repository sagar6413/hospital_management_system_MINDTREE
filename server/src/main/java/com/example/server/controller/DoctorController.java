package com.example.server.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.server.exception.ResourceNotFoundException;
import com.example.server.model.Doctor;
import com.example.server.repository.DoctorRepository;
import com.example.server.repository.PatientRepository;

@CrossOrigin
@RestController
@RequestMapping("/api/v1/")
public class DoctorController {

	@Autowired
	private DoctorRepository doctorRepository;
	
	
	
	
	
	
	//get all doctors
	@GetMapping("/doctors")
	public List<Doctor> getAllDoctors(){
		return doctorRepository.findAll();
	}
	
	//create doctor rest api
	@PostMapping("/doctors")
	public Doctor createDoctor(@RequestBody Doctor doctor) {
		return doctorRepository.save(doctor);
	}
	
	//get doctor by id rest api
	@GetMapping("/doctors/{id}")
	public ResponseEntity<Doctor> getDoctorById(@PathVariable Long id) {
		
		Doctor doctor = doctorRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Doctor not exist with id :" +id));
		return ResponseEntity.ok(doctor);
	}
	
	//update doctor rest api
	@PutMapping("/doctors/{id}")
	public ResponseEntity<Doctor> updateDoctor(@PathVariable Long id,@RequestBody Doctor doctorDetails){
		Doctor doctor = doctorRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Doctor not exist with id :" +id));
		doctor.setName(doctor.getName());
		doctor.setAge(doctor.getAge());
		doctor.setGender(doctor.getGender());
		doctor.setSpecialization(doctor.getSpecialization());
		
		Doctor updatedDoctor = doctorRepository.save(doctor);
		return ResponseEntity.ok(updatedDoctor);
	}
}
