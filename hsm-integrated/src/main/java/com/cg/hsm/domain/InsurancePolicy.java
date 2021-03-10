package com.cg.hsm.domain;

/*
 * This Class(table) consists of Insurance Policy details of a patient*
 */
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.validation.constraints.*;

@Entity
@Table(name = "insurance")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = { "createdAt" }, allowGetters = true)
public class InsurancePolicy {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	@NotNull
	private Long policyId;
	/*
	 * this is the policy name
	 */
	@Column(name = "Policy_Name")
	@NotBlank(message = "Policy Name cannot be Blank")
	private String policyName;
	/*
	 * this is the time stamp of creation or update
	 */
	@Column(name = "Created_At")
	@Temporal(TemporalType.DATE)
	@CreatedDate
	private Date createdate;

	// OnetoOne mapping with patient
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "patient_patientId", nullable = false)
	@JsonIgnore
	private Patient patients;

	@Column(updatable = false)
	private String patientIdentifier;
	@JsonBackReference

	public Patient getPatients() {
		return patients;
	}

	public void setPatients(Patient patients) {
		this.patients = patients;
	}

	public Long getPolicyId() {
		return policyId;
	}

	public void setPolicyId(Long policyId) {
		this.policyId = policyId;
	}

	public String getPolicyName() {
		return policyName;
	}

	public void setPolicyName(String policyName) {
		this.policyName = policyName;
	}

	public Date getCreatedate() {
		return createdate;
	}

	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}

	public String getPatientIdentifier() {
		return patientIdentifier;
	}

	public void setPatientIdentifier(String patientIdentifier) {
		this.patientIdentifier = patientIdentifier;
	}

	@Override
	public String toString() {
		return "InsurancePolicy [policyId=" + policyId + ", policyName=" + policyName + ", createdate=" + createdate
				+ ", patients=" + patients + ", patientIdentifier=" + patientIdentifier + "]";
	}

	public InsurancePolicy() {
		super();
		// TODO Auto-generated constructor stub
	}

}
