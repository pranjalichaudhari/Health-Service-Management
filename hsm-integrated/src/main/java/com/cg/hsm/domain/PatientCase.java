package com.cg.hsm.domain;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;

/**
 * This class will create patientHistory table in database and get all patient
 * history details
 * 
 * @author samyuktha
 *
 */
@Entity
@Table(name = "patientcase")
public class PatientCase {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	/**
	 * id of the patientCaseId
	 */
	private int patientCaseId;

	private String patientIdentifier;

	private String associatedDoctor;

	private String diseaseDescription;
	private String currentTreatment;
	private String medicine;

	private int medicineFee;

	public String getPatientIdentifier() {
		return patientIdentifier;
	}

	public void setPatientIdentifier(String patientIdentifier) {
		this.patientIdentifier = patientIdentifier;
	}

	public String getDiseaseDescription() {
		return diseaseDescription;
	}

	public void setDiseaseDescription(String diseaseDescription) {
		this.diseaseDescription = diseaseDescription;
	}

	public String getAssociatedDoctor() {
		return associatedDoctor;
	}

	public void setAssociatedDoctor(String associatedDoctor) {
		this.associatedDoctor = associatedDoctor;
	}

	public String getMedicine() {
		return medicine;
	}

	public void setMedicines(String medicine) {
		this.medicine = medicine;
	}

	public float getMedicineFee() {
		return medicineFee;
	}

	public void setMedicineFee(int medicineFee) {
		this.medicineFee = medicineFee;
	}

	public String getCurrentTreatment() {
		return currentTreatment;
	}

	public void setCurrentTreatment(String currentTreatment) {
		this.currentTreatment = currentTreatment;
	}

	public int getPatientCaseId() {
		return patientCaseId;
	}

	public void setPatientCaseId(int patientCaseId) {
		this.patientCaseId = patientCaseId;
	}

}