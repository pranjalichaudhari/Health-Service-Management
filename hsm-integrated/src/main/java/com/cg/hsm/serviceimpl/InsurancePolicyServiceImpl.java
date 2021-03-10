package com.cg.hsm.serviceimpl;

import java.util.List;


import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.hsm.exception.HSMException;
import com.cg.hsm.domain.InsurancePolicy;
import com.cg.hsm.repository.InsurancePolicyRepository;
import com.cg.hsm.service.InsurancePolicyService;

@Service
public class InsurancePolicyServiceImpl implements InsurancePolicyService {

	@Autowired
	private InsurancePolicyRepository insurancePolicyRepository;

	

	@Override
	public List<InsurancePolicy> getAllPolicies() {
		List<InsurancePolicy> policyList = (List<InsurancePolicy>) insurancePolicyRepository.findAll();
		if (policyList.size() > 0) {
			return policyList;
		} else {
			return null;
		}
	}
	@Override
	public InsurancePolicy createPolicy(InsurancePolicy insurancePolicy) throws HSMException {
		return insurancePolicyRepository.save(insurancePolicy);
	}

	@Override
	public void deletePolicyById(String patientIdentifier) throws HSMException {
		
		insurancePolicyRepository.deletePolicyByPatientIdentifier(patientIdentifier);

	
	}

	@Override
	public InsurancePolicy updatePolicy(String patientIdentifier, @Valid InsurancePolicy policyDetails)throws HSMException {
		InsurancePolicy policy = insurancePolicyRepository.findByPatientIdentifier(patientIdentifier);
		policy.setPolicyName(policyDetails.getPolicyName());
		insurancePolicyRepository.save(policy);
		return policy;
	
	}

	@Override
	public InsurancePolicy findByPatientIdentifier(String patientidentifier) {
		InsurancePolicy insurancePolicy = insurancePolicyRepository.findByPatientIdentifier(patientidentifier);
		System.out.println(insurancePolicy);
		return insurancePolicy;

	}

	
}
