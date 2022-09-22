package com.comp1.service;

import java.util.List;

import com.comp1.entity.DoctorEntity;
import com.comp1.entity.PatientEntity;

public interface HospitalService {
	
	   	public DoctorEntity showDoctorInformation(String name);
	    public PatientEntity showPatientInformation(Integer Id);
	    public boolean saveDoctorInformation(DoctorEntity doctor);
	    public boolean savePatientInformation(PatientEntity patient);
	    public List<PatientEntity> getPatientListOfDoctor(String name,DoctorEntity doctor);
	    public List<DoctorEntity> getDoctors();
}
