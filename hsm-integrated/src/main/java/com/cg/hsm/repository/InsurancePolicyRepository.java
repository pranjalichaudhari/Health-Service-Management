package com.cg.hsm.repository;


import javax.transaction.Transactional;

/*
 * This interface creates a Insurance Policy repository of a patient
 * @author Diparna Biswas
 */
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.cg.hsm.domain.InsurancePolicy;


@Repository
public interface InsurancePolicyRepository extends CrudRepository<InsurancePolicy, String> {

	@Transactional
	public void deletePolicyByPatientIdentifier(String patientIdentifier);
	@Transactional
	public InsurancePolicy findByPatientIdentifier(String patientIdentifier);
	
	

	
	
}