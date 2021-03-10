package com.cg.hsm.web;

import java.util.List;

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

import com.cg.hsm.domain.PatientCase;
import com.cg.hsm.service.MapValidationErrorService;
import com.cg.hsm.service.PatientCaseService;

@RestController
@RequestMapping("/api/patientCase")
@CrossOrigin
public class PatientCaseController {
	@Autowired
	private PatientCaseService patientCaseService;
	@Autowired
	private MapValidationErrorService mapValidationErrorService;

	
	@PostMapping("")
	public ResponseEntity<?> addPatientCase(@Valid @RequestBody PatientCase patientCase,BindingResult result){
		ResponseEntity<?> errorMap = mapValidationErrorService.mapValidationError(result);
		if (errorMap != null)
			return errorMap;
		PatientCase patientC = patientCaseService.addPatientCase(patientCase);
		return new ResponseEntity<PatientCase>(patientC, HttpStatus.OK);
		
		}
	
	@GetMapping("/{patientIdentifier}")
	public ResponseEntity<PatientCase> getAllPatientCaseById(@PathVariable String patientIdentifier) {
		PatientCase patientCases =  patientCaseService.findPatientByPatientId(patientIdentifier);
		return new ResponseEntity<PatientCase>(patientCases, HttpStatus.OK);
	}
	
	@GetMapping("/getAllPatientCases")
	public ResponseEntity<List<PatientCase>> getAllPatientCases() {
		List<PatientCase> patients = (List<PatientCase>) patientCaseService.getAllPatientCases();
		return new ResponseEntity<List<PatientCase>>(patients, HttpStatus.OK);
	}
	@GetMapping("/getAll/{disease}")
	public ResponseEntity<List<PatientCase>> getAllPatientDetailsByDisease(@PathVariable String disease) {
		List<PatientCase> patients = (List<PatientCase>) patientCaseService.getAllPatientDetailByDisease(disease);
		return new ResponseEntity<List<PatientCase>>(patients, HttpStatus.OK);
	}
	@PutMapping("/{patientIdentifier}")
	public void updatePatientCaseById(@Valid @RequestBody PatientCase patientcase ,@PathVariable String patientIdentifier)
	{
	     patientCaseService.updatePatientCase(patientIdentifier, patientcase);
	}
	@DeleteMapping("/{patientCaseId}")
	public ResponseEntity<?> deletePatientCase(@PathVariable int patientCaseId) {
		   patientCaseService.deletePatientCaseById(patientCaseId);
		return new ResponseEntity<String>("Project with id : "+patientCaseId+" deleted successfully.",HttpStatus.OK);
	}
	

}