package com.cg.hsm.repository;



import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cg.hsm.domain.PatientHistory;

@Repository
public interface PatientHistoryRepository extends CrudRepository<PatientHistory, Integer> {
	PatientHistory findByPatientIdentifier(String patientIdentifier);

	PatientHistory findByPatientId(int patientId);

}