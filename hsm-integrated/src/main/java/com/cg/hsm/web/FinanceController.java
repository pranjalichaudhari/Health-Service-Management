package com.cg.hsm.web;
/**
 * This controller is used to perform operations between UI and Database
 * @author kethu_greeshma
 */

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
import com.cg.hsm.domain.Finance;
import com.cg.hsm.service.MapValidationErrorService;
import com.cg.hsm.serviceimpl.FinanceServiceImpl;

@RestController
@RequestMapping("/api/finance")
@CrossOrigin
public class FinanceController {

	@Autowired
	private FinanceServiceImpl financeService;
	@Autowired
	private MapValidationErrorService mapValidationErrorService;
	
   @PostMapping("")
   public ResponseEntity<?> createNewFinance(@Valid @RequestBody Finance finance, BindingResult result) {
	   ResponseEntity<?> errorMap = mapValidationErrorService.mapValidationError(result);
		if (errorMap != null)
			return errorMap;
	   Finance finan = financeService.save(finance);
	   return new ResponseEntity<Finance>(finan, HttpStatus.OK);
	   
   }
   
   @PutMapping("/{patientIdentifier}")
   public ResponseEntity<?> updatePatientFinance(@Valid @RequestBody Finance finance, @PathVariable String patientIdentifier, BindingResult result){
	   ResponseEntity<?> errorMap = mapValidationErrorService.mapValidationError(result);
		if (errorMap != null)
			return errorMap;
	   Finance finan = financeService.update(finance);
	   return new ResponseEntity<Finance>(finan, HttpStatus.OK);
   }
   
   @GetMapping("/{patientIdentifier}")
	public ResponseEntity<?> getFinanceById(@PathVariable String patientIdentifier){
		Finance finance = financeService.findByPatientIdentifier(patientIdentifier);
		return new ResponseEntity<Finance>(finance, HttpStatus.OK);
	}
	
	@GetMapping("/all")
	public Iterable<Finance> getAllFinanceDetails(){
		return financeService.findAllFinanceDetails();
	}
	
	@DeleteMapping("/{patientIdentifier}")
	public ResponseEntity<?> deleteProject(@PathVariable String patientIdentifier) {
		financeService.deleteFinanceByPatientIdentifier(patientIdentifier);
		return new ResponseEntity<String>("finance with patientIdentifier : "+patientIdentifier+" deleted successfully.",HttpStatus.OK);
	}

	
}