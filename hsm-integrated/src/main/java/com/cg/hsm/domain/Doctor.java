package com.cg.hsm.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
//import javax.validation.constraints.Size;

/**
 * This class will create doctors table in database and get all doctor details
 * 
 * @author Pranjali Chaudhari
 *
 */

@Entity
@Table(name = "doctors")
public class Doctor {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	/**
	 * Id of the doctor.
	 */
	private int doctorId;
	/**
	 * Name of the doctor.
	 */
	@NotBlank(message = "Name is required")
	@Column(updatable = true, unique = false)
	private String doctorName;

	/**
	 * UserName of the doctor
	 */
	
	  @NotBlank(message = "Username is required")
	  
	  @Column(updatable=false,unique=true) private String userName;
	  
	 /**
		 * Passkey of the doctor
		 *//*
			 * @NotBlank(message = "Password is required")
			 * 
			 * @Size(min = 8 ,max = 15 ,message =
			 * "password size should between 8 to 15 characters") private String password;
			 */

	/**
	 * Contact of the doctor.
	 */
	// @NotNull(message = "Contact is required")
	// @Column(updatable=true,unique=true)
	// @Range(min = 10 ,max = 10 ,message = "Contact should be 10 characters only")
	private Long contactNumber;
	/**
	 * No of hours the doctor is available.
	 */
	private int hoursOfAvailability;
	/**
	 * Specialization details of the doctor.
	 */
	private String specialization;
	/**
	 * Degree details of the doctor.
	 */
	private String degree;
	/**
	 * Years of experience of the doctor.
	 */
	private int yearsOfExperience;
	/**
	 * Fees of the doctor.
	 */
	private float doctorFee;

	// Getters and Setters
	public int getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}

	public String getDoctorName() {
		return doctorName;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}

	public Long getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(Long contactNumber) {
		this.contactNumber = contactNumber;
	}

	public int getHoursOfAvailability() {
		return hoursOfAvailability;
	}

	public void setHoursOfAvailability(int hoursOfAvailability) {
		this.hoursOfAvailability = hoursOfAvailability;
	}

	public String getSpecialization() {
		return specialization;
	}

	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}

	public String getDegree() {
		return degree;
	}

	public void setDegree(String degree) {
		this.degree = degree;
	}

	public int getYearsOfExperience() {
		return yearsOfExperience;
	}

	public void setYearsOfExperience(int yearsOfExperience) {
		this.yearsOfExperience = yearsOfExperience;
	}

	public float getDoctorFee() {
		return doctorFee;
	}

	public void setDoctorFee(float fees) {
		this.doctorFee = fees;
	}

	
	  public String getUserName() { return userName; }
	  
	  public void setUserName(String userName) { this.userName = userName; }
	  
		/*
		 * public String getPassword() { return password; }
		 * 
		 * public void setPassword(String password) { this.password = password; }
		 */
	 
	// Parameterized Constructor
	public Doctor(int doctorId, String doctorName, Long contactNumber, int hoursOfAvailability, String specialization,
			String degree, int yearsOfExperience, float doctorFee, String userName) {
		super();
		this.doctorId = doctorId;
		this.doctorName = doctorName;
		this.contactNumber = contactNumber;
		this.hoursOfAvailability = hoursOfAvailability;
		this.specialization = specialization;
		this.degree = degree;
		this.yearsOfExperience = yearsOfExperience;
		this.doctorFee = doctorFee;
		this.userName = userName;
		//this.password = password;
		 
	}

	// Default Constructor
	public Doctor() {
		super();

	}

	// Overridden toString method
	@Override
	public String toString() {
		return "Patient [doctorId=" + doctorId + ", doctorName=" + doctorName + ", contactNumber=" + contactNumber
				+ ", hoursOfAvailability=" + hoursOfAvailability + ", specialization=" + specialization + ", degree="
				+ degree + ", yearsOfExperience=" + yearsOfExperience + ", doctorFees=" + doctorFee + "]";
	}

}
