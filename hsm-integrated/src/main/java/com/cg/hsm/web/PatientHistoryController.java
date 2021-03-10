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


import com.cg.hsm.domain.PatientHistory;
import com.cg.hsm.service.MapValidationErrorService;
import com.cg.hsm.service.PatientHistoryService;
import com.cg.hsm.serviceimpl.PatientHistoryServiceImpl;


@RestController
@RequestMapping("/api/patientHistory")
@CrossOrigin
public class PatientHistoryController {
	@Autowired
	private PatientHistoryService patientHistoryService;@Autowired
	private PatientHistoryServiceImpl patientHistoryServiceImpl;
	
	@Autowired
	private MapValidationErrorService mapValidationErrorService;

	@PostMapping("")
	public ResponseEntity<?> addPatientHistory( @Valid @RequestBody PatientHistory patientHistory,
			BindingResult result) {
		ResponseEntity<?> errorMap = mapValidationErrorService.mapValidationError(result);
		if (errorMap != null)
			return errorMap;
		PatientHistory patientHistory1 = patientHistoryService.addPatientHistory(patientHistory);
		return new ResponseEntity<PatientHistory>(patientHistory1, HttpStatus.OK);
	}

	
	
	@GetMapping("/all")
	public Iterable<PatientHistory> getAllPatientHistoriess() {
		return patientHistoryService.getAllPatientHistories();
	}
	@DeleteMapping("/{patientId}")
	public ResponseEntity<?> deletePatient(@PathVariable int patientId) {
		   patientHistoryServiceImpl.deletePatientHistoryById(patientId);
		return new ResponseEntity<String>("Project with id : "+patientId+" deleted successfully.",HttpStatus.OK);
	}
	@PutMapping("/{patientIdentifier}")
	public void updatePatientHistoryById(@Valid @RequestBody PatientHistory patientHistory ,@PathVariable String patientIdentifier)
	{
		patientHistoryServiceImpl.updatePatientHistory(patientIdentifier,patientHistory);
	}
		
	
	
	@GetMapping("/{patientIdentifier}")
	public ResponseEntity<?> getPatientHistoryById(@PathVariable String patientIdentifier){
		PatientHistory project = patientHistoryServiceImpl.findPatientHistoryByPatientId(patientIdentifier);
		return new ResponseEntity<PatientHistory>(project, HttpStatus.OK);
	}
	
}