package com.comp1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.comp1.entity.PatientEntity;
import com.comp1.exception.PatientNotFoundException;
import com.comp1.service.HospitalService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class PatientController {

	@Autowired
	private HospitalService hospitalService;

	@GetMapping("/patients/patient/{id}")
	public PatientEntity showPatientInformation(@PathVariable Integer id) {
		PatientEntity patient = hospitalService.showPatientInformation(id);
		if (patient == null) {
			throw new PatientNotFoundException(id + " is not in database");
		}
		return patient;
	}

	@PostMapping("patients/patient")
	public boolean createPatient(@RequestBody PatientEntity patient) {
		hospitalService.savePatientInformation(patient);
		return true;
	}

}