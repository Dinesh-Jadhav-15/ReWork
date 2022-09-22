package com.comp1.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.comp1.entity.DoctorEntity;
import com.comp1.entity.PatientEntity;
import com.comp1.repo.DoctorRepo;
import com.comp1.repo.PatientRepo;
import com.comp1.service.HospitalService;

@Service
public class HospitalServiceImpl implements HospitalService {

	@Autowired
	DoctorRepo doctorRepo;
	@Autowired
	PatientRepo patientRepo;

	@Override
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
