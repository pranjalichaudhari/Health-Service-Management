package com.cg.hsm.serviceimpl;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.hsm.domain.Doctor;
import com.cg.hsm.exception.HSMException;
import com.cg.hsm.repository.DoctorRepository;
import com.cg.hsm.service.DoctorService;

@Service
public class DoctorServiceImpl implements DoctorService {

	@Autowired
	private DoctorRepository doctorRepository;
	
	public Doctor findByUserName(String userName) {
		Doctor doctor = doctorRepository.findByUserName(userName);
		if (doctor == null) {
			throw new HSMException("User Name : " + userName.toUpperCase() + " does not exists");
		}
		return doctor;
	}


	@Override
	public Doctor saveDoctor(@Valid Doctor doctor) {
		return doctorRepository.save(doctor);
	}


	@Override
	public Doctor findByDoctorId(int doctorId) {
		Doctor doctor = doctorRepository.findByDoctorId(doctorId);
		if (doctor == null) {
			throw new HSMException("Doctor Id : " + doctorId + " does not exists");
		}
		return doctor;
	}


	@Override
	public List<Doctor> getAllDoctors() {
		return (List<Doctor>) doctorRepository.findAll();
	}


	@Override
	public void deleteByDoctorId(int doctorId) {
		Doctor doctor = doctorRepository.findByDoctorId(doctorId);
		if (doctor == null) {
			throw new HSMException("User Name : " + doctorId + " does not exists");
		}
		doctorRepository.delete(doctor);
		
	}


	@Override
	public Doctor updateDoctor(String userName, Doctor doctor1) {
		Doctor doctor = doctorRepository.findByUserName(userName);
		doctor.setUserName(userName);
		doctor.setDoctorName(doctor1.getDoctorName());
		doctor.setContactNumber(doctor1.getContactNumber());
		doctor.setSpecialization(doctor1.getSpecialization());
		doctor.setDegree(doctor1.getDegree());
		doctor.setHoursOfAvailability(doctor1.getHoursOfAvailability());
		doctor.setYearsOfExperience(doctor1.getYearsOfExperience());
		doctor.setDoctorFee(doctor1.getDoctorFee());
		
		Doctor updatedDoctor = doctorRepository.save(doctor);
		return updatedDoctor;
	}

	
}
