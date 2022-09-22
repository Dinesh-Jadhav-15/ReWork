package com.comp1.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
//The @Entity annotation specifies that the class is an entity and is mapped to a database table. 
public class PatientEntity {

	// @Id annotation specifies the primary key of an entity and the @GeneratedValue
	// provides for the specification of generation strategies for the values of
	// primary keys
	@Id
	@GeneratedValue
	private Integer id;
	private String name;
	private Integer age;
	@Column(unique = true) // @Column annotation is used for Adding the column the name in the table of a
							// particular MySQL database
	private String doctor_name;
	private String gender;
	private LocalDate date_of_visit;
	private String prescription;

	public LocalDate getDate_of_visit() {
		return date_of_visit;
	}

	public void setDate_of_visit(LocalDate date_of_visit) {
		this.date_of_visit = date_of_visit;
	}

	public PatientEntity(Integer id, String name, Integer age, String doctor_name, String gender,
			LocalDate date_of_visit, String prescription) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.doctor_name = doctor_name;
		this.gender = gender;
		this.date_of_visit = date_of_visit;
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

	public PatientEntity(Integer id, String name, Integer age, String doctor_name, LocalDate date_of_visit,
			String gender, String prescription) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.doctor_name = doctor_name;
		this.gender = gender;
		this.prescription = prescription;
		this.date_of_visit = date_of_visit;
	}

	@Override
	// @Override annotation indicates that the child class method is over-writing
	// its base class method.
	public String toString() {
		return "PatientEntity [id=" + id + ", name=" + name + ", age=" + age + ", doctor_name=" + doctor_name
				+ ", gender=" + gender + ", date_of_visit=" + date_of_visit + ", prescription=" + prescription + "]";
	}

}