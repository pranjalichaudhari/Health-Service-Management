package com.cg.hsm.web;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.hsm.domain.Patient;
import com.cg.hsm.service.MapValidationErrorService;

import com.cg.hsm.serviceimpl.PatientServiceImpl;

@CrossOrigin
@RestController
  @RequestMapping("/api/patients")
public class PatientController {
	@Autowired
	
	private PatientServiceImpl patientServiceImpl;
	
	@Autowired
	private MapValidationErrorService mapValidationErrorService;
	
	@PostMapping("")
	public ResponseEntity<?> createNewPatient(@Valid @RequestBody Patient patient ,  BindingResult result ) {
		ResponseEntity<?> errorMap = mapValidationErrorService.mapValidationError(result);
		if (errorMap != null)
			return errorMap;
		Patient p= patientServiceImpl.addPatient(patient); 
		return new ResponseEntity<Patient>(p,HttpStatus.CREATED);
	}
	@GetMapping("/{patientIdentifier}")
	public ResponseEntity<?> getProjectById(@PathVariable String patientIdentifier){
		Patient patient = patientServiceImpl.findPatientByIdentifier(patientIdentifier);
		return new ResponseEntity<Patient>(patient, HttpStatus.OK);
	}
	
	@GetMapping("/all")
	public Iterable<Patient> getAllPatients(){
		return patientServiceImpl.getAllPatients();
	}
	
	@DeleteMapping("/{patientIdentifier}")
	public ResponseEntity<?> deletePatient(@PathVariable String patientIdentifier) {
		   patientServiceImpl.deletePatientByIdentifier(patientIdentifier);
		return new ResponseEntity<String>("Project with id : "+patientIdentifier+" deleted successfully.",HttpStatus.OK);
	}
	@PutMapping("/{patientIdentifier}")
	public void updatePatientById(@Valid @RequestBody Patient patient ,@PathVariable String patientIdentifier)
	{
		patientServiceImpl.updatePatient(patientIdentifier,patient);
	}
}