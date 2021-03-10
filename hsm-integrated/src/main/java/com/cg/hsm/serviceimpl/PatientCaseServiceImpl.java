package com.cg.hsm.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.cg.hsm.domain.PatientCase;

import com.cg.hsm.exception.PatientCaseNotFoundException;
import com.cg.hsm.exception.PatientIdException;
import com.cg.hsm.repository.PatientCaseRepository;
import com.cg.hsm.service.PatientCaseService;




@Service
public class PatientCaseServiceImpl implements PatientCaseService {
	
	@Autowired
	private  PatientCaseRepository patientCaseRepository;
	
	
	public  PatientCase addPatientCase(PatientCase patientcase) {
		
		
		return patientCaseRepository.save(patientcase);
		
	}
   
     public List<PatientCase> getAllPatientCases(){
    	
    	 return (List<PatientCase>) patientCaseRepository.findAll();
     }
     public List<PatientCase> getAllPatientDetailByDisease(String diseaseDescription){
    	 
    	 return (List<PatientCase>) patientCaseRepository.findPatientByDiseaseDescription( diseaseDescription);
     }
     
	@Override
	public PatientCase findPatientByPatientId(String patientIdentifier) {
		PatientCase patientCase=patientCaseRepository.findByPatientIdentifier(patientIdentifier);
		if(patientCase==null) {
			throw new PatientCaseNotFoundException("Patient Case not found");
		}

		return  patientCaseRepository.findByPatientIdentifier(patientIdentifier);

	}
	public void updatePatientCase(String patientIdentifier, PatientCase patient) {
		PatientCase patient1=patientCaseRepository.findByPatientIdentifier(patientIdentifier);
		if(patient1==null) {
			throw new PatientIdException("Patient Id : " + patientIdentifier + " does not exist");
		}
		 patientCaseRepository.save(patient);	
	}

	public void deletePatientCaseById(int patientCaseId) {
		PatientCase patient=patientCaseRepository.findByPatientCaseId(patientCaseId);
		if(patient==null) {
			throw new PatientIdException("cannot delete this project with patientCaseId : " + patientCaseId + " this PatientCase does not exist");
		}
		patientCaseRepository.delete(patient);
		
	}

	

	
	

}