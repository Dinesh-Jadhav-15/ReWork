package com.comp1.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonFilter;

@Entity
@JsonFilter("DoctorFilter")
public class DoctorEntity {

	@Id
	@GeneratedValue
	private Integer id;
	@Column(unique = true)
	private String name;
	private Integer age;
	private String gender;
	private String field;
	private Integer patient_count = 0;

	@OneToMany
	private List<PatientEntity> patients;

	public List<PatientEntity> getPatients() {
		return patients;
	}

	public void addPatients(PatientEntity patient) {
		patients.add(patient);
	}

	public DoctorEntity() {
	}

	public DoctorEntity(String name, Integer age, String gender, String field) {
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.field = field;
	}

	public DoctorEntity(Integer id, String name, Integer age, String gender, String field, Integer patient_count) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.field = field;
		this.patient_count = patient_count;
	}

	@Override
	public String toString() {
		return "Doctor [age=" + age + ", field=" + field + ", gender=" + gender + ", id=" + id + ", name=" + name + "]";
	}

	public Integer getPatient_count() {
		return patient_count;
	}

	public void setPatient_count() {
		this.patient_count += 1;
	}

	public Integer getId() {
		return id;
	}

	protected void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	public Object get() {
		// TODO Auto-generated method stub
		return null;
	}
}