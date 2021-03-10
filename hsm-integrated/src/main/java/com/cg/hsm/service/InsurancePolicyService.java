package com.cg.hsm.service;

import java.util.List;

import javax.validation.Valid;
import com.cg.hsm.domain.InsurancePolicy;
import com.cg.hsm.exception.HSMException;

public interface InsurancePolicyService {

	public InsurancePolicy createPolicy( InsurancePolicy insurancePolicy);

	public List<InsurancePolicy> getAllPolicies();

	public void deletePolicyById(String patientIdentifier);

	public InsurancePolicy updatePolicy(String patientIdentifier, @Valid InsurancePolicy policyDetails)
			throws HSMException;

	public InsurancePolicy findByPatientIdentifier(String patientIdentifier);

}
