package com.cg.hsm.serviceimpl;
/**
 * This class is used to implement crud operations in Finance Database
 * @author kethu_greeshma
 */
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.hsm.domain.Doctor;
import com.cg.hsm.domain.Finance;
import com.cg.hsm.domain.Patient;
import com.cg.hsm.domain.PatientCase;
import com.cg.hsm.exception.HSMException;
import com.cg.hsm.repository.DoctorRepository;
import com.cg.hsm.repository.FinanceRepository;
import com.cg.hsm.repository.PatientCaseRepository;
import com.cg.hsm.repository.PatientRepository;
import com.cg.hsm.service.FinanceService;

@Service
public class FinanceServiceImpl implements FinanceService{

	@Autowired
	private FinanceRepository financeRepository;
	@Autowired
	private PatientRepository patientRepository;
	@Autowired
	private PatientCaseRepository patientCaseRepository;
	@Autowired
	private DoctorRepository doctorRepository;
	
	public Finance save(Finance finance) {
		
		Patient patient=patientRepository.findByPatientIdentifier(finance.getPatientIdentifier());
		//System.out.println("Patient************"+patient.getPatientName()+"       "+patient.getPatientIdentifier());
		PatientCase patientCase = patientCaseRepository.findByPatientIdentifier(finance.getPatientIdentifier());
		//System.out.println("PatientCase*************"+patientCase.getAssociatedDoctorName()+"       "+patientCase.getMedicineFee());
		//String doctorName = patientCase.getAssociatedDoctor();
		//Doctor doctor = doctorRepository.findByUserName(doctorName);
		
		finance.setPatientName(patient.getPatientName());
		finance.setPatientIdentifier(patient.getPatientIdentifier());
		finance.setRegistrationFee(patient.getAdmissionFee());
		finance.setMedicinesAmount(patientCase.getMedicineFee());
		//finance.setDoctorFee(doctor.getDoctorFee());
		//finance.setTotalFee(patient.getAdmissionFee()+patientCase.getMedicineFee()+doctor.getDoctorFee());
		finance.setDoctorFee(500);
		finance.setTotalFee(patient.getAdmissionFee()+patientCase.getMedicineFee()+500);
		try {
			return financeRepository.save(finance);
		}catch(Exception e) {
			throw new HSMException("Patient id :"+finance.getPatientIdentifier()+" already exists");
		}
	}

	
public Finance update(Finance finance) {
		String patientName = finance.getPatientName();
		finance = financeRepository.findByPatientIdentifier(finance.getPatientIdentifier());
		finance.setPatientName(patientName);
		try {
			return financeRepository.save(finance);
		}catch(Exception e) {
			throw new HSMException("Patient id :"+finance.getPatientIdentifier()+" already exists");
		}
	}
	public Finance findByPatientIdentifier(String patientIdentifier) {
		Finance finance = financeRepository.findByPatientIdentifier(patientIdentifier);
		if(finance==null) {
			throw new HSMException("Patient id :"+patientIdentifier +" not exists");
		}
		return finance;
	}

	public Iterable<Finance> findAllFinanceDetails() {
		return financeRepository.findAll();
	}

	
	
	public List<String> getPatientFinanceDetails(String patientIdentifier) {
		Finance fin = financeRepository.findByPatientIdentifier(patientIdentifier);
		List<String> report = new ArrayList<>();
		report.add("Patient name is: "+fin.getPatientName());
		report.add("finance Id is : "+fin.getPatientIdentifier());
		report.add("Admission Fee for the patient "+fin.getPatientName()+" is "+fin.getRegistrationFee());
		report.add("Doctor Fee for the patient "+fin.getPatientName()+" is "+fin.getDoctorFee());
		report.add("Medicines Amount for the patient "+fin.getPatientName()+" is "+fin.getMedicinesAmount());
		report.add("Total Fee for the patient "+fin.getPatientName()+" is "+fin.getTotalFee());
		
		return report;
		
	}

	public void deleteFinanceByPatientIdentifier(String patientIdentifier) {
		// TODO Auto-generated method stub
		Finance finance = financeRepository.findByPatientIdentifier(patientIdentifier);
		financeRepository.delete(finance);
		
	}



	
}