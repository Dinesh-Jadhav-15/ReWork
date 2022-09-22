package com.comp1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.comp1.entity.DoctorEntity;
import com.comp1.entity.PatientEntity;
import com.comp1.repo.DoctorRepo;
import com.comp1.repo.PatientRepo;

@SpringBootTest
class Comp1ApplicationTests {

	@Autowired
	private DoctorRepo doctorRepo;

	@Autowired
	private PatientRepo patientRepo;

	@Test
	void contextLoad() {

	}

	@Test
	public void test_AddDoctor() {
		DoctorEntity doctorEntities = new DoctorEntity();
		doctorEntities.setAge(20);
		doctorEntities.setField("Surgen");
		doctorEntities.setName("Dummy");
		doctorEntities.setGender("Male");
		doctorEntities.setPatient_count();

		doctorRepo.save(doctorEntities);

		assertNotNull(doctorRepo.findAll());
	}

	@Test
	public void test_getDoctor() {
		DoctorEntity doctorEntity = doctorRepo.findById(48).get();
		assertEquals("Dummy", doctorEntity.getName());
	}

	@Test
	public void test_AddPatient() {
		PatientEntity patientEntity = new PatientEntity();
		patientEntity.setAge(20);
		patientEntity.setDoctor_name("Surgen");
		patientEntity.setName("Dummy");
		patientEntity.setGender("Male");
		patientEntity.setId(20);

		assertNotNull(patientRepo.findAll());
	}

	@Test
	public void test_getPatientById() {
		PatientEntity patientEntity = patientRepo.findById(36).get();
		assertEquals("Patient 1", patientEntity.getName());

	}

}
