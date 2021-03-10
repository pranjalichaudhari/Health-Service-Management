package com.cg.hsm.domain;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Range;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="patients")
public class Patient {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer patientId;
	
	@NotBlank(message = "Patient name is required")
	@Column(unique = true , updatable = true)
	private String patientName;	
	
	@NotNull(message = "Patient Age number is required")
	private int patientAge;
	
	@Column(name = "patientContact", nullable = false, length =10)
	@NotNull(message = "Patient phone number is required")
	private long patientContact;
	
	private String address;
	
	@Column(name = "admissionFee", nullable = false)
	@NotNull(message = "Patient admission Fee is required")
	@Range(min = 200,max=1000)
	private int admissionFee;

	
	private String patientIdentifier;

	public String getPatientIdentifier() {
		return patientIdentifier;
	}
	public void setPatientIdentifier(String patientIdentifier) {
		this.patientIdentifier = patientIdentifier;
	}
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date created_At;
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date updated_At;

	// getters and setters
	//@JsonManagedReference
	/*
	 * public List<PatientHistory> getPatientHistories() { return patientHistories;
	 * } public void setPatientHistories(List<PatientHistory> patientHistories) {
	 * this.patientHistories = patientHistories; }
	 */
	public String getPatientName() {
		return patientName;
	}
	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}
	public Integer getPatientId() {
		return patientId;
	}
	public void setPatientId(Integer patientId) {
		this.patientId = patientId;
	}
	
	
	/*
	 * @JsonManagedReference public PatientCase getPatientCases() { return
	 * patientCases; } public void setPatientCases(PatientCase patientCases) {
	 * this.patientCases = patientCases; }
	 */
	public int getPatientAge() {
		return patientAge;
	}
	public void setPatientAge(int patientAge) {
		this.patientAge = patientAge;
	}
	public long getPatientContact() {
		return patientContact;
	}
	public void setPatientContact(long patientContact) {
		this.patientContact = patientContact;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	public int getAdmissionFee() {
		return admissionFee;
	}
	public void setAdmissionFee(int admissionFee) {
		this.admissionFee = admissionFee;
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
	/*
	 * @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy =
	 * "patients") private List<PatientHistory> patientHistories = new
	 * ArrayList<>();
	 * 
	 * 
	 * @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy =
	 * "patients") private PatientCase patientCases;
	 */

	@PrePersist
	public void onCreate() {
		this.created_At=new Date();
	}
	@PreUpdate
	public void onUpdate() {
		this.updated_At=new Date();
	}
}