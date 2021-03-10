package com.cg.hsm.service;

/**
 * This interface is used to perform Crud operations in Database
 * @author kethu_greeshma
 */
import java.util.List;

import com.cg.hsm.domain.Finance;

public interface FinanceService {
	/**
	 * This is used to saveOr update the finance object of a patient
	 * 
	 * @param patientIdentifier
	 * @param finance
	 * @return
	 */
	Finance save(Finance finance);

	Finance update(Finance finance);

	/**
	 * This is used to find the finance object of a patient using patient identifier
	 * 
	 * @param patientIdentifier
	 * @return
	 */
	Finance findByPatientIdentifier(String patientIdentifier);

	/*
	 * Used to find the patient finance details present in Database
	 */
	Iterable<Finance> findAllFinanceDetails();

	/**
	 * This is used to get the finance report of a patient by using patient
	 * identifier
	 * 
	 * @param patientIdentifier
	 * @return
	 */
	List<String> getPatientFinanceDetails(String patientIdentifier);

	void deleteFinanceByPatientIdentifier(String patientIdentifier);
}