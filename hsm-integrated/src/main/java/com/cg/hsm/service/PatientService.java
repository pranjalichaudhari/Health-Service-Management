package com.cg.hsm.service;

import javax.validation.Valid;

import com.cg.hsm.domain.Patient;



public interface PatientService {
	
	public Patient addPatient(@Valid Patient patient);
	
	public Patient findPatientByIdentifier(String patientIdentifier);
	
	public Iterable<Patient> getAllPatients();
	
	public void deletePatientByIdentifier(String patientIdentifier);
	
	public Patient updatePatient(String patientIdentifier,Patient patient);
	
}