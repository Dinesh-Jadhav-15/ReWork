package com.comp1.repo;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.comp1.entity.PatientEntity;


@Repository
public interface PatientRepo extends CrudRepository<PatientEntity,Integer> {

}
