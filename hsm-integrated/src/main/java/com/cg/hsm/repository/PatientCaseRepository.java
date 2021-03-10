package com.cg.hsm.repository;



import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cg.hsm.domain.PatientCase;
@Repository
public interface PatientCaseRepository extends CrudRepository<PatientCase,Integer>{

	PatientCase findByPatientIdentifier(String patientIdentifier);

     List<PatientCase> findPatientByDiseaseDescription(String diseaseDescription);
	
     PatientCase findByPatientCaseId(int patientCaseId);
}