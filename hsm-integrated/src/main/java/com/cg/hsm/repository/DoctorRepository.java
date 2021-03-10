package com.cg.hsm.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cg.hsm.domain.Doctor;

@Repository
public interface DoctorRepository extends CrudRepository<Doctor, Long> {

	Doctor findByDoctorId(int doctorId);

	Doctor findByUserName(String username);
}