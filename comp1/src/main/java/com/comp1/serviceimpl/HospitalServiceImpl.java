package com.comp1.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.comp1.entity.DoctorEntity;
import com.comp1.entity.PatientEntity;
import com.comp1.repo.DoctorRepo;
import com.comp1.repo.PatientRepo;
import com.comp1.service.HospitalService;

@Service // @Service annotation is used with classes that provide some business
			// functionalities
public class HospitalServiceImpl implements HospitalService {

	@Autowired
	// The @Autowired annotation can be used to autowire bean on the setter method
	// just like @Required annotation, constructor, a property or methods with
	// arbitrary names and/or multiple arguments.
	DoctorRepo doctorRepo;

	@Autowired
	PatientRepo patientRepo;

	@Override
	// @Override annotation indicates that the child class method is over-writing
	// its base class method.
	public DoctorEntity showDoctorInformation(String name) {
		return doctorRepo.findByName(name);
	}

	@Override
	public PatientEntity showPatientInformation(Integer id) {
		return patientRepo.findById(id).get();
	}

	@Override
	public boolean saveDoctorInformation(DoctorEntity doctor) {
		doctorRepo.save(doctor);
		return true;
	}

	@Override
	public boolean savePatientInformation(PatientEntity patient) {

		DoctorEntity doctor = doctorRepo.findByName(patient.getDoctor_name());
		doctor.addPatients(patient);
		patientRepo.save(patient);
		doctor.setPatient_count();
		return true;
	}

	@Override
	public List<PatientEntity> getPatientListOfDoctor(String name, DoctorEntity doctor) {
		return doctor.getPatients();
	}

	@Override
	public List<DoctorEntity> getDoctors() {
		return (List<DoctorEntity>) doctorRepo.findAll();
	}
}
