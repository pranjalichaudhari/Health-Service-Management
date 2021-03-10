package com.cg.hsm.domain;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.validation.constraints.NotNull;
import com.fasterxml.jackson.annotation.JsonFormat;
/**
 * This class is used to store the finance table attributes
 * @author kethu_greeshma
 *
 */
@Entity
public class Finance{

	/**
	 * financeId attribute stores the id of a finance object
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long financeId;
	
	@NotNull(message="patient name required")
	private String patientIdentifier;
	
	/**
	 * patientName attribute stores name of a patient
	 */
	private String patientName;
	/**
	 * doctorFee attribute stores the fee of a doctor
	 */
	private double doctorFee;
	/**
	 * registrationFee attribute stores the registrationFee of a patient
	 */
	private double registrationFee;
	/**
	 * medicinesAmount attribute stores the medicines amount of a patient
	 */
	private double 	medicinesAmount;
	/**
	 * totalFee attribute stores the total fee of a patient
	 */
	private double totalFee;
	/**
	 * createdBy attribute will store the name of the person who's storing the details  in database
	 */
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date created_At;
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date updated_At;
	//Constructor
	public Finance() {
		
	}
	//Parameterized Constructor
	public Finance(String patientName, double registrationFee, double doctorFee, double medicinesAmount, double totalFee) {
		this.patientName = patientName;
		this.registrationFee = registrationFee;
		this.doctorFee = doctorFee;
		this.medicinesAmount = medicinesAmount;
		this.totalFee = totalFee;
	}
	//Getters and setters
	public Long getFinanceId() {
		return financeId;
	}
	public void setFinanceId(Long financeId) {
		this.financeId = financeId;
	}
	public String getPatientName() {
		return patientName;
	}
	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}
	public double getRegistrationFee() {
		return registrationFee;
	}
	public void setRegistrationFee(double registrationFee) {
		this.registrationFee = registrationFee;
	}
	public double getDoctorFee() {
		return doctorFee;
	}
	public void setDoctorFee(double doctorFee) {
		this.doctorFee = doctorFee;
	}
	public double getMedicinesAmount() {
		return medicinesAmount;
	}
	public void setMedicinesAmount(double medicinesAmount) {
		this.medicinesAmount = medicinesAmount;
	}
	public double getTotalFee() {
		return totalFee;
	}
	public void setTotalFee(double totalFee) {
		this.totalFee = totalFee;
	}

	@PrePersist
	public void onCreate() {
		this.created_At =  new Date();
	}
	
	@PreUpdate
	public void onUpdate() {
		this.updated_At =  new Date();
	}

	public Date getCreated_At() {
		return created_At;
	}

	public void setCreated_At(Date created_At) {
		this.created_At = created_At;
	}

	public Date getUpdated_At() {
		return updated_At;
	}

	public void setUpdated_At(Date updated_At) {
		this.updated_At = updated_At;
	}
	
	public String getPatientIdentifier() {
		return patientIdentifier;
	}
	public void setPatientIdentifier(String patientIdentifier) {
		this.patientIdentifier = patientIdentifier;
	}
	@Override
	public String toString() {
		return "Finance [patientName=" + patientName + ", doctorFee=" + doctorFee
				+ ", registrationFee=" + registrationFee + ", medicinesAmount=" + medicinesAmount + ", totalFee="
				+ totalFee + "]";
	}
	
}