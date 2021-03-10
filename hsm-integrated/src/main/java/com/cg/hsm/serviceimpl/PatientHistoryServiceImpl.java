package com.cg.hsm.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.cg.hsm.domain.PatientHistory;
import com.cg.hsm.exception.HSMException;
import com.cg.hsm.repository.PatientHistoryRepository;
import com.cg.hsm.service.PatientHistoryService;

@Service
public class PatientHistoryServiceImpl implements PatientHistoryService{
	@Autowired
	private PatientHistoryRepository patientHistoryRepositary;
	public PatientHistory addPatientHistory(PatientHistory patientHistory) {
		
		return patientHistoryRepositary.save(patientHistory);

	}
	
	


	public Iterable<PatientHistory> getAllPatientHistories() {

		return patientHistoryRepositary.findAll();
	}
	public void deletePatientHistoryById(int patientId) {
		PatientHistory patientHistory=patientHistoryRepositary.findByPatientId(patientId);
		if(patientHistory==null) {
			throw new HSMException("cannot delete this project with patientId : " + patientId + " this Patient does not exist");
		}
		patientHistoryRepositary.delete(patientHistory);
		
	}
	
	public PatientHistory findPatientHistoryByPatientId(String patientIdentifier) {
		PatientHistory patientHistory=patientHistoryRepositary.findByPatientIdentifier(patientIdentifier);
		if(patientHistory==null) {
		throw new HSMException("Patient  not found");
			
			
		}

		return  patientHistoryRepositary.findByPatientIdentifier(patientIdentifier);

	}
	 
	 public PatientHistory updatePatientHistory(String patientIdentifier,PatientHistory patientHistory) { 
			/*
			 * patientHistory=patientHistoryRepositary.findByPatientIdentifier(
			 * patientHistory.getPatientIdentifier()); if(patientHistory==null) { throw new
			 * HSMException("cannot delete this project with patientId :this Patient does not exist"
			 * ); }
			 */
		
	  	return patientHistoryRepositary.save(patientHistory);
  
  }
	

}