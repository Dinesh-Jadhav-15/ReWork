package com.comp1.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class PatientEntity {

	@Id
	@GeneratedValue
	private Integer id;
	private String name;
	private Integer age;
	@Column(unique = true)
	private String doctor_name;
	private String gender;
	private String prescription;

	public PatientEntity(Integer id, String name, Integer age, String doctor_name, String gender, String prescription) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.doctor_name = doctor_name;
		this.gender = gender;
		this.prescription = prescription;
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

	public String getPrescription() {
		return prescription;
	}

	public void setPrescription(String prescription) {
		this.prescription = prescription;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDoctor_name() {
		return doctor_name;
	}

	public void setDoctor_name(String doctor_name) {
		this.doctor_name = doctor_name;
	}

	public PatientEntity() {
	}

	@Override
	public String toString() {
		return "Patient [ doctor_name=" + doctor_name + ", id=" + id + ", name=" + name + "]";
	}

	public PatientEntity(Integer id, String name, Integer age, String doctor_name, LocalDate date_of_visit,
			String gender, String prescription) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.doctor_name = doctor_name;
		this.gender = gender;
		this.prescription = prescription;
	}

}