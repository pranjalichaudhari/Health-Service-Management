package com.cg.hsm.web;

import java.util.List;


import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.hsm.exception.HSMException;
import com.cg.hsm.domain.InsurancePolicy;
import com.cg.hsm.service.InsurancePolicyService;


@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api")
public class InsurancePolicyController {

	@Autowired
	InsurancePolicyService insurancePolicyservice;
	
	
	@GetMapping("/policies")
	 public List<InsurancePolicy> getAllPolicies() throws HSMException {
		return insurancePolicyservice.getAllPolicies();
	}
	
	@PostMapping("/policies")
	public InsurancePolicy createPolicy(@Valid @RequestBody InsurancePolicy insurancePolicy)throws HSMException {
	 return insurancePolicyservice.createPolicy( insurancePolicy);
			
	}
	@PutMapping("/policies/{patientIdentifier}")   //update
	public InsurancePolicy updatePolicy(@PathVariable String patientIdentifier , @Valid @RequestBody InsurancePolicy policyDetails) throws HSMException{
		return insurancePolicyservice.updatePolicy(patientIdentifier, policyDetails);
	}
	
	@DeleteMapping("/policies/{patientIdentifier}")
	public void deletePolicyById(@PathVariable String patientIdentifier )throws HSMException {
			insurancePolicyservice.deletePolicyById(patientIdentifier);
	       
	}
	@GetMapping("/policies/{patientIdentifier}")
	public InsurancePolicy findByPatientIdentifier(@PathVariable String patientIdentifier) {
		System.out.println("Inside boot");
		return insurancePolicyservice.findByPatientIdentifier(patientIdentifier);
	}
	

}
