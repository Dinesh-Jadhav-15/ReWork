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

@SpringBootTest // @SpringBootTest annotation tells Spring Boot to look for a main configuration
				// class (one with @SpringBootApplication , for instance) and use that to start
				// a Spring application context
class Comp1ApplicationTests {

	@Autowired // The @Autowired annotation can be used to autowire bean on the setter method
				// just like @Required annotation, constructor, a property or methods with
				// arbitrary names and/or multiple arguments.
	private DoctorRepo doctorRepo;

	@Autowired // @Override annotation indicates that the child class method is over-writing
				// its base class method.
	private PatientRepo patientRepo;

	@Test // @SpringBootTest annotation tells Spring Boot to look for a main configuration
			// class and use that to start a Spring application context
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
