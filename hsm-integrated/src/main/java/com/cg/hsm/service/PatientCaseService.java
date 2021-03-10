package com.cg.hsm.service;

import java.util.List;

import com.cg.hsm.domain.PatientCase;



public interface PatientCaseService {
	public  PatientCase addPatientCase(PatientCase patientcase);
	 public List<PatientCase> getAllPatientCases();
	public PatientCase findPatientByPatientId(String patientIdentifier);
	 public List<PatientCase>getAllPatientDetailByDisease(String diseaseDescription);
	//public PatientCase findPatientCaseByPatientIdentifier(String patientIdentifier);
	 public void updatePatientCase(String patientIdentifier,PatientCase patientcase);
	 public void deletePatientCaseById(int patientCaseId);
	 
}