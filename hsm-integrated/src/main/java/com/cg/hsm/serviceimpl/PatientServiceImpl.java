package com.cg.hsm.serviceimpl;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.hsm.domain.Patient;
import com.cg.hsm.domain.PatientCase;
import com.cg.hsm.domain.PatientHistory;
import com.cg.hsm.exception.HSMException;
import com.cg.hsm.repository.PatientCaseRepository;
import com.cg.hsm.repository.PatientHistoryRepository;
import com.cg.hsm.repository.PatientRepository;
import com.cg.hsm.service.PatientService;

@Service
public class PatientServiceImpl implements PatientService {
	@Autowired
	private PatientRepository patientRepository;
	@Autowired
	private PatientHistoryRepository patientHistoryRepository;
	@Autowired
	private PatientCaseRepository patientCaseRepository;
	
	@Override
	public Patient addPatient(@Valid Patient patient) {
		
		String identifier = patient.getPatientName();
		int i=1;
		i++;
		identifier = identifier+i;
		patient.setPatientIdentifier(identifier);
		/*
		 * String identifier = patient.getPatientName(); int i=1; i++; identifier =
		 * identifier+i; patient.setPatientIdentifier(identifier); try {
		 * patient.setPatientId(patient.getPatientId());
		 * if(patient.getPatientId()==null) { PatientHistory patientHistory=new
		 * PatientHistory() ; patientHistory.setPatient(patient);
		 * patientHistory.setPatientIdentifier(patient.getPatientIdentifier().
		 * toUpperCase()); PatientCase patientCase=new PatientCase() ;
		 * patientCase.setPatient(patient);
		 * patientCase.setPatientIdentifier(patient.getPatientIdentifier().toUpperCase()
		 * );
		 * 
		 * } //String identifier; if(patient.getPatientId()!=null) {
		 * 
		 * identifier=patient.getPatientIdentifier();
		 * patient.setPatientHistories(patientHistoryRepository.findByPatientIdentifier(
		 * identifier.toUpperCase()));
		 * patient.setPatientCases(patientCaseRepository.findByPatientIdentifier(
		 * identifier.toUpperCase())); }
		 */
		return patientRepository.save(patient);
	}
	/*
	 * catch(Exception e) { throw new HSMException( "Patient Id : " +
	 * patient.getPatientIdentifier().toUpperCase() + " already exists"); } }
	 */
	
	public Iterable<Patient> getAllPatients() {
		return patientRepository.findAll();
	}
	@Override
	public void deletePatientByIdentifier(String patientIdentifier) {
		Patient patient=patientRepository.findByPatientIdentifier(patientIdentifier);
		if(patient==null) {
			throw new HSMException("cannot delete this patient with : " + patientIdentifier + " as this Patient does not exist");
		}
		patientRepository.delete(patient);
		
	}
	 
	
	@Override
	public Patient updatePatient(String patientIdentifier, Patient patient) {
		/*
		 * patient=patientRepository.findByPatientIdentifier(patientIdentifier);
		 * if(patient==null) { throw new HSMException("Patient Id : " +
		 * patientIdentifier + " does not exist"); }
		 */
		return patientRepository.save(patient);
		}
	@Override
	public Patient findPatientByIdentifier(String patientIdentifier) {
		Patient patient=patientRepository.findByPatientIdentifier(patientIdentifier);
		if(patient==null) {
			throw new HSMException("Patient Id : " + patientIdentifier + " does not exist");
		}
		return patient;
	}

}