package com.comp1.repo;

import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.data.repository.CrudRepository;

import com.comp1.entity.DoctorEntity;

@Repository
@CrossOrigin(origins = "http://localhost:4200")
public interface DoctorRepo extends CrudRepository<DoctorEntity,Integer> {

	public DoctorEntity findByName(String name);
}



