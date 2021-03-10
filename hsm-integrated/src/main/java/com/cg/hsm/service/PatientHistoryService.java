package com.cg.hsm.service;
import com.cg.hsm.domain.PatientHistory;

public interface PatientHistoryService {
	public PatientHistory addPatientHistory(PatientHistory patientHistory);
	
	 
	 public Iterable<PatientHistory> getAllPatientHistories();
	
}